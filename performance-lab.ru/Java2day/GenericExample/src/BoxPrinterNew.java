public class BoxPrinterNew<T> {
        private T val;

        public BoxPrinterNew(T val){
            this.val = val;
        }

        @Override
        public String toString() {
            return "{" + val + "}";
        }

        public T getVal() {
            return val;
        }
    }