package net.eric.protocol;

/**
 * @author Eric Zhao
 * @date 2018/2/17
 */
public class ErrorResponse {

    private String error;

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
