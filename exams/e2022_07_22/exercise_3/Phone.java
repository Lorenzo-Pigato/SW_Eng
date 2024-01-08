package exams.e2022_07_22.exercise_3;

public class Phone {
    private Type mode;

    public Phone() {
        this.mode = Type.SILENT;
    }

    public void getNotification() {
        this.mode.getMode().displayNotification();
    }

    public void setMode(String mode) {
        for (Type t : Type.values()) {
            if (t.getName().equalsIgnoreCase(mode))
                this.mode = t;
        }
    }

    public static void main(String[] args) {
        Phone myPhone = new Phone();
        myPhone.getNotification();
        myPhone.getNotification();
        myPhone.setMode("Ring");
        myPhone.getNotification();
    }
}

enum Type {
    SILENT("silent", new Mode() {
        @Override
        public void displayNotification() {
            System.out.println("New message");
        }
    }),
    ALERT("alert", new Mode() {
        @Override
        public void displayNotification() {
            System.out.println("* Flash light* New Alert * Flash Light*");
        }
    }),
    RING("ring", new Mode() {
        @Override
        public void displayNotification() {
            System.out.println("New message");
            ring();
        }

        private void ring() {
            System.out.println("*Ringtone*");
        }
    }),
    AIRPLANE("airplane", new Mode() {
        @Override
        public void displayNotification() {
            System.out.println(" - - - ");
        }
    });

    private Mode mode;
    private String name;

    Type(String name, Mode mode) {
        this.name = name;
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public Mode getMode() {
        return mode;
    }
}
