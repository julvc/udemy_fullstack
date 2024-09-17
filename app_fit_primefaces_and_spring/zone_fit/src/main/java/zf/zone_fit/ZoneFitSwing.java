package zf.zone_fit;

import javax.swing.SwingUtilities;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import com.formdev.flatlaf.FlatDarculaLaf;

import zf.zone_fit.gui.ZoneFitForma;

@SpringBootApplication
public class ZoneFitSwing {
    public static void main(String[] args) {
        // configuramos el modo oscuro
        FlatDarculaLaf.setup();
        // Instancia la fabrica de spring
        ConfigurableApplicationContext contextoSpring =
                new SpringApplicationBuilder(ZoneFitSwing.class)
                        .headless(false)
                        .web(WebApplicationType.NONE)
                        .run(args);
        // Crear un objeto de Swing
        SwingUtilities.invokeLater(()-> {
            ZoneFitForma zonaFitForma = contextoSpring.getBean(ZoneFitForma.class);
            zonaFitForma.setVisible(true);
        });
    }
}
