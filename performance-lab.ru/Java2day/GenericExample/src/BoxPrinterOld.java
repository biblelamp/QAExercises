public class BoxPrinterOld {
    private Object val;

    public BoxPrinterOld(Object val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "{" + val + "}";
    }

    public Object getVal() {
        return val;
    }
}
