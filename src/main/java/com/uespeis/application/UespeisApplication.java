// 
// Decompiled by Procyon v0.5.36
// 

package com.uespeis.application;

import java.nio.file.Files;

import com.uespeis.model.Activity;
import com.uespeis.model.ActivityUserQuestion;
import com.uespeis.model.Resources;
import com.uespeis.model.SubActivity;

import java.net.URISyntaxException;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.util.Map;
import java.nio.file.FileSystems;
import java.net.URI;
import java.util.HashMap;
import java.nio.file.Path;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.boot.SpringApplication;
import org.apache.logging.log4j.LogManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import com.uespeis.service.ActivityService;
import com.uespeis.service.ActivityUserQuestionService;
import com.uespeis.service.ResourceService;
import com.uespeis.service.SubActivityService;

import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EntityScan({ "com.uespeis.model", "com.uespeis.service_impl" })
@ComponentScan({ "com.uespeis.controller", "com.uespeis.service_impl" })
@EnableJpaRepositories({ "com.uespeis.repository" })
public class UespeisApplication {
    private static final Logger log = LogManager.getLogger(UespeisApplication.class);
    @Autowired
    private ResourceService service;
    @Autowired
    private SubActivityService saService;
    @Autowired
    private ActivityUserQuestionService auqService;

    public static void main(final String[] args) {
        SpringApplication.run(UespeisApplication.class, args);
    }

    @EventListener({ ApplicationReadyEvent.class })
    private void initResources() {
        this.initResource(true, 1, 1200, 1200, null, "Actividad1.png");
        this.initResource(true, 2, 800, 900, null, "Actividad1_2.png");
        this.initResource(true, 4, 800, 900,
                "Para poder funcionar bien es muy importante que nuestro cerebro tenga la energía\r\nsuficiente. Si no nos alimentamos de manera correcta o nos saltamos comidas, no\r\npodremos avanzar en nuestro plan, porque nuestro cuerpo no podrá seguir el ritmo.",
                "Actividad2_1.png");
        this.initResource(true, 5, 800, 900,
                "¿Has escuchado alguna vez que somos un 70% agua? Quien lo dijo no iba muy mal\r\nencaminado, ya que nuestros mecanismos corporales y nuestras células necesitan estar en\r\nun medio acuoso para funcionar correctamente. Por eso, es muy importante proporcionar\r\nla hidrataciín correcta a nuestro cuerpo.",
                "Actividad2_2.png");
        this.initResource(true, 6, 800, 900,
                "Durante las horas de sueño se produce una reparación a nivel fisiolígico en nuestro\r\ncerebro: eliminamos toxinas y radicales libres, generados por la oxidaciín que se produce al usarlo. ¡Pero el sueño también es muy importante a nivel psicolígico! Es en este momento cuando procesamos todo lo que nos ha ido pasando a lo largo del día, le damos orden y sentido y “archivamos” la información. Como ves, el sueño es més importante de lo que parece.",
                "Actividad2_3.png");
        this.initResource(true, 7, 800, 900,
                "¿Qué actividades haces en tu día a día? No, el trabajo no cuenta. Nos referimos a\r\nactividades que te ayuden a salir de ese bucle en el que, a veces, nos metemos en la vida\r\ncotidiana. Actividades agradables que nos produzcan bienestar cuando las hacemos (por\r\nejemplo, pintar, pasear, hacer deporte, cantar, meditar) o actividades sociales que me\r\npermitan conectar con las personas con las que nos sentimos a gusto (quedar con amigos,\r\nuna cita con mi pareja, actividades en grupo…).",
                "Actividad2_4.png");
        this.initResource(true, 8, 800, 900,
                "Todos estos aspectos van a influir en cómo me voy a sentir. Las emociones son muy\r\nimportantes en nuestro día a día. Lo veremos con más detalle a lo largo este\r\nentrenamiento.",
                "Actividad2_5.png");
        this.initResource(true, 9, 800, 900,
                "Todo buen entrenamiento comienza con un calentamiento. ¡No íbamos a ser menos! En\r\ntu primera semana deberás “calentar” contestando a unas preguntas relacionadas con tus\r\nhábitos de alimentación, hidratación, sueño, actividades agradables y sociales y tus\r\nemociones. Contestaremos a estas preguntas en 4 días diferentes de la semana al final del\r\ndía.",
                "Actividad2_6.png");
        this.initResource(true, 10, 800, 1000, null, "Actividad3_1.png");
        this.initResource(true, 12, 800, 1000, null, "Actividad3_2.png");
        this.initResource(true, 13, 800, 1000, null, "Actividad3_3.png");
        this.initResource(false, 16, 800, 1000, null, "Actividad3_4.png");
        UespeisApplication.log.info("corriendo despues del initResources");
    }

    private byte[] getByteArrayFromResource(final String name) throws IOException {
        return new ClassPathResource(name).getContentAsByteArray();
    }

    private void initResource(boolean actividad, Integer id, final Integer height, final Integer width,
            final String relatedText, final String name) {
        if (actividad) {
            new Thread(() -> {
                try {
                    SubActivity subActivity = this.saService.findById(id);
                    if (subActivity.getResources() == null) {
                        Resources res = this.service.save(Resources.builder().height(height).width(width)
                                .relatedText(relatedText).resource(getByteArrayFromResource(name)).build());
                        subActivity.setResources(res);
                        this.saService.save(subActivity);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } else {
            new Thread(() -> {
                try {
                    ActivityUserQuestion aQuestion = this.auqService.findById(id);
                    if (aQuestion.getResources() == null) {
                        Resources res = this.service.save(Resources.builder().height(height).width(width)
                                .relatedText(relatedText).resource(getByteArrayFromResource(name)).build());
                        aQuestion.setResources(res);
                        this.auqService.save(aQuestion);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
