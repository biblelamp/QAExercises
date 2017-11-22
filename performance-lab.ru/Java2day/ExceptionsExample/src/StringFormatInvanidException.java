public class StringFormatInvanidException extends RuntimeException {
    String format;

    StringFormatInvanidException(String format, String msg) {
        super(msg);
        this.format = format;
    }

    @Override
    public String getMessage() {
        return "Format: " + format + "\n" +super.getMessage();
    }
}
