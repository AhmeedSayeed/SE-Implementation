package Validation;

import Users.User;

/**
 * Represents a validation service that checks whether a user object is valid.
 * The implementation of this interface should define the logic for user validation.
 */
public interface IValidation {

    /**
     * Validates the given user object.
     *
     * @param user the user object to validate
     * @return true if the user is valid, false otherwise
     */
    public Boolean validate(User user);
}
