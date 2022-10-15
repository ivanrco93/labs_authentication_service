package devforce.labs.authentication.swagger;

import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.entity.error.ApiError;
import devforce.labs.authentication.exception.DatabaseUserException;
import devforce.labs.authentication.exception.InvalidUserException;
import devforce.labs.authentication.exception.UserNotFoundException;
import devforce.labs.authentication.query.entity.Query;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Tag(name = "User Controller")
public interface UserControllerSwagger {
    @Operation(
            summary = "Retrieve user info",
            description = "Users data"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = String[].class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ApiError.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ApiError.class)))
            }
    )
    ResponseEntity<Object> retrieveAllUsers();

    @Operation(
            summary = "Retrieve user info",
            description = "Users data"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = String[].class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ApiError.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ApiError.class)))
            }
    )
    ResponseEntity<Object> retrieveFilteredUsers(
            List<Query> query,
            HttpServletRequest httpServletRequest
    );

    @Operation(
            summary = "Retrieve user info by id",
            description = "Users data"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = String[].class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ApiError.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ApiError.class)))
            }
    )
    ResponseEntity<Object> retrieveUserById(
            Integer id,
            HttpServletRequest httpServletRequest
    );

    @Operation(
            summary = "Retrieve user info by uuid",
            description = "Users data"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = String[].class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ApiError.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ApiError.class)))
            }
    )
    ResponseEntity<Object> retrieveUserByUUID(
            String UUID,
            HttpServletRequest httpServletRequest
    ) throws UserNotFoundException;

    @Operation(
            summary = "Create a new user",
            tags = {"CREATE_USER"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = User.class))),
                    @ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = User.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = User.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ApiError.class)))
            }
    )
    ResponseEntity<Object> createUser(
            User user,
            HttpServletRequest httpServletRequest,
            BindingResult bindingResult
    ) throws DatabaseUserException, InvalidUserException, UserNotFoundException;

    @Operation(
            summary = "Create a new user",
            tags = {"CREATE_USER"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = User.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = User.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ApiError.class)))
            }
    )
    ResponseEntity<Object> updateUser(
            User user,
            HttpServletRequest httpServletRequest,
            BindingResult bindingResult
    );
}
