package students_xlsx_data.exceptions;

public class CustomGenericException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public CustomGenericException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
