package totoBetApp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class TotoApp {

    private TotoApp(){}

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        TotoAppController controller = context.getBean(TotoAppController.class);
        controller.createData();
        controller.createPlayer();
        controller.betting();
    }
}

