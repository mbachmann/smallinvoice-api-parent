package com.example.smallinvoice.springfeign;

import com.example.smallinvoicespringfeign.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportingTest extends SharedTest {

    private int contactId = 0;
    ContactGET contact = null;
    AuthProfileGET user = null;

    @Override
    @BeforeEach
    public void setUp() {
        try {
            contactId = createContactIfNotExistsFromResource("contact/contact2.json", "contact/address1.json", "contact/people1.json", "contact/account1.json");
            contact = apiService.getContactById(contactId, "main_address,groups,permissions,custom_fields");
            contactId = contact.getId();
            user = apiService.getAuthUserProfile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getActivities() throws Exception {
        String with = "permissions";
        String filter = null;
        @Valid List<ActivityGET> activities = apiService.getReportingActivities(with, filter);
        String json = mapToJson(activities);
        if (activities.size() > 0) {
            ActivityGET activity = apiService.getReportingActivityById(activities.get(0).getId(), with);
            assertEquals(mapToJson(activities.get(0)), mapToJson(activity));
        }
    }

    @Test
    public void getCostUnits() throws Exception {
        String filter = null;
        @Valid List<ReportingCostUnitGET> costUnits = apiService.getReportingCostUnits(filter);
        String json = mapToJson(costUnits);
        if (costUnits.size() > 0) {
            ReportingCostUnitGET costUnit = apiService.getReportingCostUnitById(costUnits.get(0).getId());
            assertEquals(mapToJson(costUnits.get(0)), mapToJson(costUnit));
        }

    }

    @Test
    public void getEfforts() throws Exception {
        String  with = "user_name,activity_name,permissions";
        String filter = null;
        @Valid List<ReportingEffortGET> efforts = apiService.getReportingEfforts(with, filter);
        String json = mapToJson(efforts);
        if (efforts.size() > 0) {
            ReportingEffortGET activity = apiService.getReportingEffortById(efforts.get(0).getId(), with);
            assertEquals(mapToJson(efforts.get(0)), mapToJson(activity));
        }
    }

    @Test
    public void getProjects() throws Exception {
        String with = "contact_name,permissions";
        String filter = null;
        @Valid List<ReportingProjectGET> efforts = apiService.getReportingProjects(with, filter);
        String json = mapToJson(efforts);
        if (efforts.size() > 0) {
            ReportingProjectGET effort = apiService.getReportingProjectById(efforts.get(0).getId(), with);
            assertEquals(mapToJson(efforts.get(0)), mapToJson(effort));
        }
    }

    @Test
    public void createAndChangeProject() throws Exception {

        String jsonProject = readResource(new ClassPathResource("reporting/project1.json"));
        ReportingProjectPOST project = mapFromJson(jsonProject, ReportingProjectPOST.class);

        project
                .startDate(LocalDate.now())
                .contactId(contactId)
                .hourlyRate(100F)
                .description("This is a description");

        ReportingProjectGET projectGET = apiService.createReportingProject(project);

        assertEquals(project, mapFromJson(mapToJson(projectGET), ReportingProjectPOST.class).number(null));

        // Change the new project and save it again with update
        projectGET.setHourlyRate(110F);
        projectGET.setHoursEstimated(200F);

        ReportingProjectGET projectUpdated = apiService.updateReportingProject(projectGET);
        if (projectUpdated != null) {
            assertEquals(projectGET, projectUpdated);
            ReportingProjectGET changeProject = apiService.changeReportingProjectStatusById(projectUpdated.getId(),ReportingProjectGET.StatusEnum.P);
            if (changeProject != null) assertEquals(changeProject.getStatus(), ReportingProjectGET.StatusEnum.P);
        }

        TimeUnit.MILLISECONDS.sleep(100);
    }


    @Test
    public void getWorkingHours() throws Exception {
        String with = "user_name,permissions";
        String filter = null;
        @Valid List<WorkingHoursGET> workingHours = apiService.getWorkingHours(with, filter);
        String json = mapToJson(workingHours);
        if (workingHours.size() > 0) {
            WorkingHoursGET workingHour = apiService.getWorkingHourById(workingHours.get(0).getId(), with);
            assertEquals(mapToJson(workingHours.get(0)), mapToJson(workingHour));
        }
    }

    @Test
    public void createAndChangeWorkingHours() throws Exception {

        String jsonWorkingHour = readResource(new ClassPathResource("reporting/workinghours1.json"));
        WorkingHoursPOST workingHour = mapFromJson(jsonWorkingHour, WorkingHoursPOST.class);

        workingHour
                .date(LocalDate.now())
                .timeStart(LocalTime.now().minusMinutes(1))//.truncatedTo(ChronoUnit.MINUTES))
                .timeEnd(LocalTime.now().truncatedTo(ChronoUnit.MINUTES))
                .userId(user.getId());

        WorkingHoursGET workingHoursGET = apiService.createWorkingHour(workingHour);
        assertEquals(workingHour, mapFromJson(mapToJson(workingHoursGET), WorkingHoursPOST.class));

        // Change the new working hour and save it again with update
        workingHoursGET.setTimeEnd(workingHoursGET.getTimeEnd().plusMinutes(1));
        workingHoursGET.setTimeStart(workingHoursGET.getTimeStart().plusMinutes(1));

        WorkingHoursGET workingHourUpdated = apiService.updateWorkingHour(workingHoursGET);
        if (workingHourUpdated != null) assertEquals(workingHoursGET, workingHourUpdated);

        TimeUnit.MILLISECONDS.sleep(100);
    }





}
