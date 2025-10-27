package api;

public class Nhan2soResponse {
    private boolean success;
    private String message;
    private Integer result; 

    public Nhan2soResponse() {}

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Integer getResult() { return result; }
    public void setResult(Integer result) { this.result = result; }
}