class Create {
    public static Runnable createRunnable(String text, int repeats) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println((text + "\n").repeat(repeats));
            }
        };
    }
}