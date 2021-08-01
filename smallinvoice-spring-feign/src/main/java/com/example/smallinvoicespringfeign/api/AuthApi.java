/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.smallinvoicespringfeign.api;

import com.example.smallinvoicespringfeign.model.AuthPOST;
import com.example.smallinvoicespringfeign.model.ItemAuthOwnerGET;
import com.example.smallinvoicespringfeign.model.ItemAuthProfileGET;
import com.example.smallinvoicespringfeign.model.Response401;
import com.example.smallinvoicespringfeign.model.Response4xx;
import com.example.smallinvoicespringfeign.model.TokenPairGET;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T13:05:18.255013+02:00[Europe/Zurich]")
@Validated
@Api(value = "Auth", description = "the Auth API")
public interface AuthApi {

    /**
     * POST /auth/access-tokens : Receives token pair for Bearer authorization
     *
     * @param authPOST  (optional)
     * @return Token pair (status code 201)
     */
    @ApiOperation(value = "Receives token pair for Bearer authorization", nickname = "authAccessTokensPost", notes = "", response = TokenPairGET.class, tags={ "Auth", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Token pair", response = TokenPairGET.class) })
    @PostMapping(
        value = "/auth/access-tokens",
        produces = "application/json",
        consumes = "application/json"
    )
    ResponseEntity<TokenPairGET> authAccessTokensPost(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) AuthPOST authPOST);


    /**
     * GET /auth/profile : Returns data of authenticated user&#39;s profile
     * Returns data of authenticated user&#39;s profile
     *
     * @return Data of the authenticated user&#39;s profile (status code 200)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Method not allowed (status code 405)
     *         or Too many requests (status code 429)
     *         or Server error (status code 500)
     */
    @ApiOperation(value = "Returns data of authenticated user's profile", nickname = "getAuthUserProfile", notes = "Returns data of authenticated user's profile", response = ItemAuthProfileGET.class, authorizations = {
        
        @Authorization(value = "bearerAuth"),
        @Authorization(value = "oauth", scopes = {
            @AuthorizationScope(scope = "profile", description = "Profile") })
         }, tags={ "Auth", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Data of the authenticated user's profile", response = ItemAuthProfileGET.class),
        @ApiResponse(code = 400, message = "Bad request", response = Response4xx.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Response401.class),
        @ApiResponse(code = 405, message = "Method not allowed", response = Response4xx.class),
        @ApiResponse(code = 429, message = "Too many requests", response = Response4xx.class),
        @ApiResponse(code = 500, message = "Server error") })
    @GetMapping(
        value = "/auth/profile",
        produces = "application/json"
    )
    ResponseEntity<ItemAuthProfileGET> getAuthUserProfile();


    /**
     * GET /auth/owner : Returns data of authenticated resource owner
     * Returns data of authenticated resource owner
     *
     * @return Data of the authenticated resource owner (status code 200)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Method not allowed (status code 405)
     *         or Too many requests (status code 429)
     *         or Server error (status code 500)
     */
    @ApiOperation(value = "Returns data of authenticated resource owner", nickname = "getAuthenticatedResourceOwner", notes = "Returns data of authenticated resource owner", response = ItemAuthOwnerGET.class, authorizations = {
        
        @Authorization(value = "bearerAuth"),
        @Authorization(value = "oauth", scopes = {
            @AuthorizationScope(scope = "profile", description = "Profile") })
         }, tags={ "Auth", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Data of the authenticated resource owner", response = ItemAuthOwnerGET.class),
        @ApiResponse(code = 400, message = "Bad request", response = Response4xx.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Response401.class),
        @ApiResponse(code = 405, message = "Method not allowed", response = Response4xx.class),
        @ApiResponse(code = 429, message = "Too many requests", response = Response4xx.class),
        @ApiResponse(code = 500, message = "Server error") })
    @GetMapping(
        value = "/auth/owner",
        produces = "application/json"
    )
    ResponseEntity<ItemAuthOwnerGET> getAuthenticatedResourceOwner();

}
