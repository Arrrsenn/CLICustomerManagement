public class MyErrors extends Exception {

    public MyErrors(String str) {
        super(str);
    }

    public static class NoCorrectedNameExcepton extends MyErrors {
        public NoCorrectedNameExcepton() {
            super("Имя задано не корректно! Корректный формат: Василий Петров");
        }
    }

    public static class NoCorrectedPhoneExcepton extends MyErrors {
        public NoCorrectedPhoneExcepton() {
            super("Номер телефона задан не корректно! Корректный формат: +79215637722 или 89215637722");
        }
    }

    public static class NoCorrectedEmailExcepton extends MyErrors {
        public NoCorrectedEmailExcepton() {
            super("E-mail задан не корректно! Корректный формат: vasily.petrov@gmail.com");
        }
    }

}
