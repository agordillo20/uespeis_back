--RESOURCES
INSERT IGNORE INTO resources(id,height,width,related_text,resource) VALUES
(1,1200,1200,null,"Actividad1.png"),
(2,800,900,null,"Actividad1_2.png"),
(3,800,900,"Para poder funcionar bien es muy importante que nuestro cerebro tenga la energía\r\nsuficiente. Si no nos alimentamos de manera correcta o nos saltamos comidas, no\r\npodremos avanzar en nuestro plan, porque nuestro cuerpo no podrá seguir el ritmo.","Actividad2_1.png"),
(4,800,900,"¿Has escuchado alguna vez que somos un 70% agua? Quien lo dijo no iba muy mal\r\nencaminado, ya que nuestros mecanismos corporales y nuestras células necesitan estar en\r\nun medio acuoso para funcionar correctamente. Por eso, es muy importante proporcionar\r\nla hidrataciín correcta a nuestro cuerpo.","Actividad2_2.png"),
(5,800,900,"Durante las horas de sueño se produce una reparación a nivel fisiolígico en nuestro\r\ncerebro: eliminamos toxinas y radicales libres, generados por la oxidaciín que se produce al usarlo. ¡Pero el sueño también es muy importante a nivel psicolígico! Es en este momento cuando procesamos todo lo que nos ha ido pasando a lo largo del día, le damos orden y sentido y “archivamos” la información. Como ves, el sueño es més importante de lo que parece.","Actividad2_3.png"),
(6,800,900,"¿Qué actividades haces en tu día a día? No, el trabajo no cuenta. Nos referimos a\r\nactividades que te ayuden a salir de ese bucle en el que, a veces, nos metemos en la vida\r\ncotidiana. Actividades agradables que nos produzcan bienestar cuando las hacemos (por\r\nejemplo, pintar, pasear, hacer deporte, cantar, meditar) o actividades sociales que me\r\npermitan conectar con las personas con las que nos sentimos a gusto (quedar con amigos,\r\nuna cita con mi pareja, actividades en grupo…).","Actividad2_4.png"),
(7,800,900,"Todos estos aspectos van a influir en cómo me voy a sentir. Las emociones son muy\r\nimportantes en nuestro día a día. Lo veremos con más detalle a lo largo este\r\nentrenamiento.","Actividad2_5.png"),
(8,800,900,"Todo buen entrenamiento comienza con un calentamiento. ¡No íbamos a ser menos! En\r\ntu primera semana deberás “calentar” contestando a unas preguntas relacionadas con tus\r\nhábitos de alimentación, hidratación, sueño, actividades agradables y sociales y tus\r\nemociones. Contestaremos a estas preguntas en 4 días diferentes de la semana al final del\r\ndía.","Actividad2_6.png"),
(9,800,1000,null,"Actividad3_1.png"),
(10,700,1000,null,"Actividad3_2.png"),
(11,800,1000,null,"Actividad3_3.png"),
(12,800,1000,null,"Actividad3_4.png"),
(13,800,1000,null,"Actividad3_5.png"),
(14,800,1000,null,"Actividad4_1.png"),
(15,800,1000,null,"Actividad5_1.png"),
(17,800,1000,null,"Actividad5_3.png"),
(18,800,1000,null,"Actividad6_1.png"),
(19,800,1000,null,"Actividad6_2.png"),
(20,800,1000,null,"Actividad6_3.png"),
(21,800,1000,null,"Actividad6_4.png"),
(22,800,1000,null,"Actividad6_5.png"),
(23,800,1000,null,"Actividad6_6.png"),
(24,800,1000,null,"Actividad6_7.png"),
(25,800,1000,null,"Actividad7_1.png"),
(26,800,1000,null,"Actividad7_2.png"),
(27,800,1000,null,"Actividad7_3.png"),
(28,null,null,null,"relajacion.mp3"),
(29,null,null,null,"visualizacion.mp3");

--PROFILES
INSERT IGNORE INTO profile(id,age,study,civil_status,employment_status,gender,height,weight,mental_illness,physical_illness,smoke_ever,smoker,sick_leave) VALUES(1,"23","Sin estudios","Soltero","Desempleado","Hombre","170","60",0,0,0,0,0);

--USERS
INSERT IGNORE INTO user(id,email,password,rol,locked,profile_id) VALUES (1,"admin@uespeis.com","$argon2id$v=19$m=16384,t=2,p=1$XZ5W0FzBndVwMGsl1YFFjg$4ohePxI+37tNBUP1z24vPC5q0pbFVJ1H6U1n4wA9eHo","CONSULTANT",0,null),(2,"test@uespeis.com","$argon2id$v=19$m=16384,t=2,p=1$XZ5W0FzBndVwMGsl1YFFjg$4ohePxI+37tNBUP1z24vPC5q0pbFVJ1H6U1n4wA9eHo","DEFAULT",0,1);

--QUESTIONS
INSERT IGNORE INTO question(id,interrogation,title,type) VALUES(1,"He tenido pensamientos y sentimientos desagradables y lo he aceptado","EN LAS ÚLTIMAS DOS SEMANAS ...","ACEPTACIÓN"),(2,"He intentado reconciliarme con mis pensamientos y sentimientos negativos en vez de resistirme a ellos.","EN LAS ÚLTIMAS DOS SEMANAS ...","ACEPTACIÓN"),(3,"He estado atento/a y he sido consciente de mis emociones.","EN LAS ÚLTIMAS DOS SEMANAS ...","CONSCIENCIA EN EL MOMENTO PRESENTE"),(4,"He entendido mis pensamientos y sentimientos en cada momento.","EN LAS ÚLTIMAS DOS SEMANAS ...","CONSCIENCIA EN EL MOMENTO PRESENTE"),(5,"He intentado mantener una visión de conjunto, incluso cuando me he sentido dolido/a o enfadado/a.","EN LAS ÚLTIMAS DOS SEMANAS ...","YO COMO CONTEXTO"),(6,"Contemplar mi vida desde una perspectiva más amplia me ha permitido superar momentos difíciles.","EN LAS ÚLTIMAS DOS SEMANAS ...","YO COMO CONTEXTO"),(7,"He sido capaz de dejar que los sentimientos negativos se fueran y vinieran sin verme atrapado/a en ellos.","EN LAS ÚLTIMAS DOS SEMANAS ...","DEFUSION"),(8,"Cuando me he enfadado, he sido capaz de dejar pasar esos sentimientos negativos sin aferrarme a ellos.","EN LAS ÚLTIMAS DOS SEMANAS ...","DEFUSION"),(9,"He sido muy consciente de lo que es importante para mí y para mi vida.","EN LAS ÚLTIMAS DOS SEMANAS ...","VALORES"),(10,"Me he mantenido fiel a las prioridades que son fundamentales en mi vida.","EN LAS ÚLTIMAS DOS SEMANAS ...","VALORES"),(11,"Incluso cuando he cometido errores, he seguido esforzándome por lo que es importante.","EN LAS ÚLTIMAS DOS SEMANAS ...","ACCION COMPROMETIDA"),(12,"Incluso en momentos difíciles, he sido capaz de avanzar hacia lo que valoro en mi vida.","EN LAS ÚLTIMAS DOS SEMANAS ...","ACCION COMPROMETIDA"),(13,"Cuando me ha venido a la cabeza un mal recuerdo he intentado distraerme para que se vaya.","EN LAS ÚLTIMAS DOS SEMANAS ...","EVITACION EXPERIENCIAL"),(14,"Cuando he sentido emociones desagradables he intentado distraerme.","EN LAS ÚLTIMAS DOS SEMANAS ...","EVITACION EXPERIENCIAL"),(15,"He hecho la mayoría de las cosas de forma automática, con poca consciencia de lo que estaba haciendo.","EN LAS ÚLTIMAS DOS SEMANAS ...","FALTA DE CONTACTO CON EL MOMENTO PRESENTE"),(16,"He hecho la mayoría de las cosas sin pensar y sin prestar mucha atenciOn.","EN LAS ÚLTIMAS DOS SEMANAS ...","FALTA DE CONTACTO CON EL MOMENTO PRESENTE"),(17,"He pensado que algunas de mis emociones eran malas o inapropiadas y no debería sentirlas.","EN LAS ÚLTIMAS DOS SEMANAS ...","YO COMO CONTENIDO"),(18,"Me he criticado por sentir emociones irracionales o inapropiadas.","EN LAS ÚLTIMAS DOS SEMANAS ...","YO COMO CONTENIDO"),(19,"Los pensamientos y sentimientos negativos han tendido a acompañarme durante mucho tiempo.","EN LAS ÚLTIMAS DOS SEMANAS ...","FUSION"),(20,"Los pensamientos desagradables han tendido a dar vueltas por mi mente como un disco rayado.","EN LAS ÚLTIMAS DOS SEMANAS ...","FUSION"),(21,"Mis prioridades y valores a menudo han pasado a un segundo plano en mi vida diaria.","EN LAS ÚLTIMAS DOS SEMANAS ...","FALTA DE CONTACTO CON LOS VALORES"),(22,"Cuando he estado muy agobiado/a, a menudo he perdido el contacto con las cosas que valoro.","EN LAS ÚLTIMAS DOS SEMANAS ...","FALTA DE CONTACTO CON LOS VALORES"),(23,"Los sentimientos negativos a menudo me han paralizado.","EN LAS ÃLTIMAS DOS SEMANAS...","INACCION"),(24,"Los sentimientos negativos han interrumpido mis planes con facilidad.","EN LAS ÚLTIMAS DOS SEMANAS ...","INACCION");

--FORMS
INSERT IGNORE INTO form(id,loocked,user_id) VALUES(1,0,2);

--ACTIVITY PARENTS
INSERT IGNORE INTO activity_parent VALUES (1,"Lo que a ti te impulsa"),(2,"Engrasando la máquina"),(3,"Consiguiendo lo necesario…"),(4,"Pensando en cómo pienso…"),(5,"Atrévete a sentir"),(6,"¿Cómo continuamos y mantenemos lo conseguido?");

--ACTIVITY
INSERT IGNORE INTO activity(id,text,parent,total_for_complete) VALUES (1,"Lo que a ti te impulsa",1,1),(2,"Engrasando la máquina",2,4),(3,"Una rutina diaria estable",3,1),(4,"Entrenando mi nivel de activación",3,3),(5,"Pensando en cómo pienso…",4,1),(6,"Conociendo las emociones",5,1),(7,"¿Qué haces tú para gestionar tus emociones?",5,2),(8,"¿Cómo continuamos y mantenemos lo conseguido?",6,1);

--SUB ACTIVITY
INSERT IGNORE INTO sub_activity(id,parent,text,clave,together,resources) VALUES 
(1,1,"Empezar a entrenar es algo que, a la mayoría de mortales, puede costarnos un poco. El día que toca gimnasio siempre surge alguna excusa tentadora.\n\nPero siempre hay algo en nuestro interior que nos impulsa y nos hace seguir hacia delante.\nEso es lo que nos permite ser constantes y continuar caminando.",null,0,1),
(2,1,"¿QUÉ TE IMPULSA A TI?\nEste programa es un reto que requiere esfuerzo y constancia. Para no flaquear en días difíciles, tenemos que saber muy bien cuál es nuestro objetivo, el motor que nos recuerda por qué estamos aquí y que nos ayuda a seguir cada día.", "Todos nos movemos por algo; recuerda tus metas.",0,2),
(3,2,"Antes de empezar a trabajar hay que parar y escucharse: ¿Cómo te sientes? ¿Tienes cubiertas tus necesidades básicas? ¿Cómo es tu día a día? Para contestar a estar preguntas debemos fijarnos en estos aspectos básicos:", null,1,null),
(4, 2, NULL, null,1,3),
(5, 2, NULL, null,1,4),
(6, 2, NULL, null,1,5),
(7, 2, NULL, null,1,6),
(8, 2, NULL, "Cuerpo y mente son un todo inseparable; para sentirte bien en todos los sentidos no puedes olvidar la alimentación, la hidratación, el sueño y el realizar actividades agradables.",1,7),
(9, 2, NULL, null,1,8),
(10,3,"Como hemo visto en el segundo punto “Engrasando la máquina” hay cosas básicas que\nnecesitamos tener en nuestra vida para estar estables y que nuestras emociones también lo\nsean. Maslow, en su teoría sobre las necesidades humanas básicas, nos las ordena en forma de\npirámide.",null,0,9),
(11,3,"¿Tienes la base de la pirámide? ¿Cuáles han sido los resultados de tus registros en el punto anterior?",null,1,10),
(12,3,"¿Tienes que modificar alguno de estos aspectos para poder poner tu cuerpo en funcionamiento y que pueda dar el 100% para conseguir tus objetivos?",null,1,null),
(13,3,"TODOS tenemos algo que mejorar, así que vamos a ponernos a ello. ¿Qué tengo que hacer?\n1. Elige algo que modificar (eliminar, añadir, disminuir, aumentar) en tu rutina. ¿Cómo?\nRespóndete a estas preguntas para ello:",null,0,null),
(14,3,"2. Especifica ese “algo” a modificar\n\nPor ejemplo, no es una buena formulación “no estar tan estresado”. Habría que indicar“realizar la técnica de relajación después de comer.”","Para mejorar, elige metas específicas, medibles, delimitadas y realistas.",0,11),
(15,3,"3. Planifica cómo vas a modificarlo\n\nEn la mayoría de los casos, por una u otra cosa, es difícil modificar nuestra rutina diría. Por ello,es importante dividir lo que quieres modificar en los pasos necesarios para poder llegar aconseguirlo.\nSiendo el ejemplo anterior, si me estoy acostando a las 2 de la madrugada, no voy a poder cambiarlo de un día para otro sino que voy a tener que ir haciéndolo poco a poco (de 15 en 15 minutos).\nCompleta los pasos para alcanzar lo que te has propuesto:","Planifica qué, cuándo y cómo podría hacerlo. Piensa realista y ten en cuenta los“contras” para prevenirlos.",0,null),
(16,4,"<div>
    <p>¿Sientes nerviosismo? ¿A veces tienes palpitaciones? ¿Sientes mariposas en el estomágo (y no es por estar conociento
        al amor de tu vida…)? ¿Tienes muchas contracturas, te duele el cuello y/o la cabeza? Si tu cerebro va a 3000
        revoluciones por minuto pueden pasar estas cosas y es importante bajar su activación antes de “quemarlo”. Esto te
        puede ayudar. ¿Sabes lo importante que es la respiración? A nivel general, le da información a nuestro cerebro de
        cómo estamos y, a la vez, este controla cómo nos sentimos a través de ella. La respiración que se realiza en
        situaciones de tensión involucra a la parte superior de la caja torácica pero la respiración relajada involucra al
        diafragma.
    </p> 
    <h4>¿Cómo saber qué tipo de respiración utilizamos habitualmente?</h4>
    <ul>
        <li style='margin-left: 10px;'>Ponte de pie y coloca una mano sobre el pecho y otra sobre el estómago.</li>
        <li style='margin-left: 10px;'>Respira con normalidad. Al inhalar, observa tus manos, ¿cuál de ellas se mueve?</li>
    </ul>
</div>",null,1,14),
(17,4,"Si es la mano que está sobre el estómago, estás haciendo una respiración diafragmática. Los hombros y el pecho no deberían moverse.\nSi es la mano que está sobre el pecho, la respiración es pectoral o superficial, que es menos eficaz y no produce los beneficios de una respiración más profunda.Vamos a utilizar la respiración diafragmática. ¿Practicas?",null,1,null),
(18,4,"Con la idea de la respiración ya aprendida, vamos a pasar a reducir nuestro nivel de activación. ¿Cónocemos alguna técnica de relajación? Esa nos vendría bien practicar diarimente. \n Si no es así, aquí te dejamos 2 opciones que te pueden ser de utilidad. Son dos audios (de dos técnicas diferentes para que puedas probar cuál te gusta más) que te guian para aprender a bajar tu nivel de activación. \n ","no olvides regular tu activación para estar en un nivel funcional para funcionar",0,null),
(19,5,"Seguimos con otra parte de nuestro entrenamiento emocional, LOS PENSAMIENTOS.\nNOTA: no olvides seguir practicando C1: la rutina estable y C2: el nivel de activación.",null,1,15),
(20,5,"Sí, nuestros pensamientos están completamente ligados a nuestras emociones. Párate un segundo y piensa en algún momento en que estuvieras nervioso porque pensabas que algo malo iba a ocurrir (y al final no fue así). Ahora piensa en algún momento en el que te enfadaste con alguien porque pensabas que te había hecho algo a propósito y después no fue así.\nNuestros pensamientos acerca de una situación pueden marcar la forma en la que nos sentimos y nos comportamos. En el ejemplo anterior, si te enfadas por lo que piensas, ¿cómo puedes reaccionar? Pero, después, ¿y si las cosas no han ocurrido como las pensabas? ¿Y si has sufrido “para nada”?\nEsto nos lleva a plantearnos… ¿Nuestros pensamientos nos pueden engañar?",null,1,null),
(21,5,"En efecto, sí, en nuestra cabeza saltan pensamientos automáticos, modos de interpretar la realidad que, a veces, no son 100% objetivos y reales. Son los errores del pensamiento. Existen muchos tipos de entre los que tenemos:\n<table border='1'><thead><tr><td>Nombre</td><td>Descripción</td><td>Ejemplo de pensamiento erroneo</td></tr></thead><tbody><tr><td>Adivinación del porvenir</td><td>La persona cree saber lo que va a pasar en un futuro próximo o lejano, siempre con una visión catastrofista. </td><td>Seguro que irá mal, no sacaré la plaza y van a terminar echando. </td></tr><tr><td>Afirmaciones tipo “Debería” / “Tendría” </td><td>La persona tiene una lista de reglas rígidas de cómo hay que actuar, creyendo que son las correctas. CLAVE: debería, no debería, tendría que, no tendría que,…</td><td>Tendría que poder hacer cinco series, no es normal para el tiempo que llevo entrenando, no puede ser.  </td></tr><tr><td>Razonamiento Emocional</td><td>La persona cree que lo que siente es lo verdadero, automáticamente. Si se siente así, es porque las cosas son así.</td><td>No estoy nada cómodo en la reunión, es una porquería de sesión, no sirve para nada.</td></tr><tr><td>Sobregeneralización</td><td>La persona extrae una conclusión general de un simple incidente o solo una parte de la evidencia. Palabras clave: nadie, todo, siempre, nunca,…</td><td>Siempre me pasa lo mismo, nunca doy ni una. A todos les sale bien menos a mí.</td></tr><tr><td>Lectura e interpretación del pensamiento</td><td>La persona cree saber lo que los demás están pensando, sintiendo o van a hacer; cree conocer sus motivos e intenciones. Es capaz de adivinar que piensan y sienten los demás sobre ella.</td><td>Seguro que me pone también el próximo turno; lo hace para fastidiar, sabe que no puedo entrar a esa hora.</td></tr></tbody></table>",null,0,null),
(22,5,"¿Has tenido algún pensamiento de este tipo? ¿Algún otro que recuerdes que, al final, no era como lo habías creído?",null,1,null),
(23,5,"<p>Sí, los has debido de tener… Todos los seres humanos tenemos estos pensamientos erróneos, es normal. La cuestión aquí está en qué es lo que hacemos con ellos; tenemos dos opciones:</p>
<ol type='a'> 
    <li>Los consideramos como verdaderos y nos dejamos guiar por ellos. Sacamos conclusiones que no son reales, nos sentimos mal y actuamos de manera disfuncional.</li>
    <li>Nos percatamos de que no son realistas y los ignoramos, generando otros pensamientos alternativos. Nuestro nivel de malestar es menor y nuestro comportamiento es más funcional.</li>
</ol>
<p>¿Cómo me doy cuenta de si estoy teniendo pensamientos erróneos?
Es importante escucharte, pararte a analizar si lo que piensas es o no 100% real. Pero cuidado, porque nuestro cerebro es muy bueno en hacernos creer que sí y tendremos que estar muy atentos. </p>
Para saberlo y ayudarte a salir de ello, respóndete a las siguientes preguntas: ","si estás sintiéndote mal ¡PARA! y analiza si estás teniendo pensamientos erróneos o esas emociones son ajustadas a lo que está pasando en realidad.",0,null),
(24,5,"Estas preguntas están diseñadas para flexibilizar tu pensamiento, para que no te quedes estancado en el error si no que puedas ver otras interpretaciones alternativas y más funcionales. No se trata de auto-engañarse, sino de flexibilizar y ajustarse a la realidad, la cual, a veces, también será negativa y será importante aceptar las emociones que nos suscita.\n¿LO VEMOS EN EL SIGUIENTE NIVEL?",null,0,17),
(25,6,"Después de haber aprendido a trabajar nuestra activación y entender nuestros pensamientos, ahora nos toca aprender a escucharnos. ¿Qué sabes sobre EMOCIONES?\nNOTA: no olvides seguir practicando La rutina estable, El nivel de activación y Pensando en cómo pienso.",null,0,18),
(26,6,"Todos tenemos emociones, aunque no todas las emociones son igual de agradables: hay emociones que nos gusta más que otras. Por ejemplo, suele ser común que prefiramos sentir alegría, calma o ilusión antes que tristeza, miedo o culpa. Sería tentador pensar en quedarnos solo con las emociones más agradables y “deshacernos” de las emociones desagradables, hacer como si no existieran. Pero ¿realmente sería útil?  Desgraciadamente, no tendría muy buenos resultados. \nImagina por un momento cómo sería tu vida sin sentir emociones: ¿Cómo sabrías qué te gusta y por dónde debes seguir? ¿Cómo sabrías de qué debes alejarte o qué no te conviene? ¿Cómo sabrías si estás en peligro?\nTODAS las emociones son buenas y sirven para algo, son como una brújula que nos indica qué debemos hacer y hacia dónde ir.",null,0,19),
(27,6,"Existen muchas emociones y cada una de ellas nos da información importante para resolver las situaciones de nuestro día a día. Podemos clasificar las emociones en primarias y secundarias. De las primarias surgen el resto de emociones secundarias (que son muchas). Veamos brevemente cual es la función “natural” de las emociones primarias:",null,0,20),
(28,6,"Alegría: Nos ayuda a identificar qué queremos en nuestra vida y cuales son las cosas que valoramos y hace más probable que repitas una acción. Por ejemplo: si estás contento cuando estás con un amigo, ¡seguramente vuelvas a quedar con él!\nMiedo: Nos sirve como alarma y nos avisa en situaciones que podrían ser peligrosas para que tengamos precaución. Por ejemplo: si estoy en un lugar alto sin barandilla y me acerco al borde, sentiré miedo.\nTristeza: Suele aparecer tras perder algo importante para nosotros. Nos indica que algo no va bien y que debemos parar para procesar esa pérdida. Es un ejemplo de una emoción que genera malestar pero que es tremendamente útil.\nEnfado: Nos indica que nuestros límites han sido traspasados de alguna manera y nos impulsa a actuar para solucionarlo. Por ejemplo: si en el trabajo haces algo que te ha costado mucho esfuerzo y luego un compañero dice al jefe que ha sido el quien lo ha hecho (te “roba” tu trabajo) puedes sentir enfado.\nAsco: Implica rechazo hacia algo que nos resulta desagradable. Esta emoción, surgió como la manera “adaptativa” de alejarnos de situaciones potencialmente dañinas (alimentos en mal estado, falta de higiene que puede llevarnos a contraer una infección o enfermedad…).",null,1,null),
(29,7,"Que todas las emociones sirvan para algo, no quiere decir que las emociones sean fáciles de manejar. De hecho, muchas veces nos cuesta saber qué estamos sintiendo, porqué lo estamos sintiendo y qué hacer con esa emoción.\nCada emoción, de forma “natural”, nos impulsan a actuar de una manera determinar. Sin embargo, a veces, ese “impulso” no nos ayuda mucho. Por ejemplo, si yo me enfado con alguien, puede ser que el enfado me impulse a querer gritar a la persona, pero eso, no sería lo mejor.\nDesde pequeños, aprendemos estrategias para manejar ese impulso “natural” que nos generan las emociones. En función de lo que vea en casa, en el colegio o me vaya sirviendo en la vida, aprenderé estrategias más útiles (o adaptativas) o menos útiles. Veamos un ejemplo donde una persona puede utilizar diferentes estrategias:\n",null,0,21),
(30,7,"DIFERENTES TIPOS DE ESTRATEGIAS\nEl ejemplo anterior nos enseña diferentes estrategias. Existen muchos tipos de estrategias, nosotros vamos a centrarnos en algunas y vamos a clasificarlas en dos grandes categorías:",null,0,22),
(31,7,"ESTRATEGIAS DE EVITACIÓN / SUPERISÓN / HUÍDA: \nSon todas aquellas estrategias que hacen que no sienta o no me enfrente a la emoción. Por ejemplo:",null,0,23),
(32,7,"ACEPTACIÓN\nMuchas de las estrategias mencionadas suelen ocurrir debido a que no aceptamos la emoción que estamos sintiendo. Nuestra sociedad no ve con buenos ojos sentir emociones. No está permitido estar triste: ¿a cuantos de nosotros no nos han dicho alguna vez “venga, no llores, tienes que seguir”? Esto nos lleva a intentar controlar lo que sentimos: nos obligamos a no sentir la tristeza o la rabia. Pero, ERROR, porque eso nunca funciona. Hagamos un pequeño ejercicio para entenderlo:\nQuiero que NO pienses, ni se te ocurra pensar, ni por un momento, en una MARIPOSA ROSA.",null,0,null),
(33,7,"¿Qué ha ocurrido?",null,0,24),
(34,7,"Cuando hacemos este ejercicio es inevitable que la mariposa venga a nuestra cabeza. Lo mismo ocurre con las emociones. Cuanto más intentemos quitarlas más aparecerán. Debemos permitirnos SENTIR las emociones, darles su espacio para poder gestionarlas de manera correcta.
<ol>
    <li style='margin-left: 10px;'>Aceptarlas.</li>
    <li style='margin-left: 10px;'>Buscar una estrategia que me ayude a gestionar esa situación</li>
</ol>
",null,1,null),
(35,8,"Si repasamos nuestro entrenamiento, puedes observar que hemos completado el siguiente esquema:",null,1,25),
(36,8,"¿Lo reconoces?",null,0,null),
(37,8,"",null,1,26),
(38,8,"Ya sabemos que, para hacer frente a una situación (máxime si es estresante), necesitamos: 
-	Que nuestra máquina esté bien engrasada, con una buena alimentación, hidratación, sueño y actividades agradables. 
-	Tener un nivel de activación funcional, ni muy bajo (mi cerebro estaría apagado) ni muy alto (con mi cerebro a 3000 revoluciones por minuto). 
-	Tener unas metas realistas y bien definidas por las que trabajar paso a paso. 
-	Que nuestros pensamientos sean flexibles y no erróneos, ya que si no nos generaran emociones y conductas disfuncionales: 
-	Entender qué emoción estamos sintiendo en ese momento, aceptarla y buscar una estrategia que nos ayude para regularlas.
Como hemos visto en el esquema anterior, TODO está relacionado; mi manera de interpretar la situación va a dar lugar a la emoción (y viceversa) y, esta, marcará lo que yo haga. Todo ello está intrínseca y bidireccionalmente relacionado con mi parte física, fisiológica. Trabajar en todo ello me ayuda a estar más estable y a vivir con más flexibilidad. 
",null,0,null),
(39,8,"",null,1,27),
(40,8,"Lo que hemos ido viendo son “claves” para reducir el malestar y flexibilizar nuestros pensamientos. Esto nos ayudará a gestionar mejor el día a día, el trabajo, la familia, los amigos, etc. Pero es importante profundizar en ello y mantener el ritmo de trabajo. Sin esfuerzo y constancia no hay resultados.  
Ya la tienes abiertas todas y ahora llega la otra de aplicarlo y ponerlo en práctica en el día de día, ¡de verdad! Si no aplicamos las habilidades aprendidas se olvidan ya que no las hemos automatizado. Este es el proceso que puedes comenzar ahora. Sé tu propio entrenador y a pro ello. 
Antes de seguir, ¿vemos tus avances respecto al principio? Completo el test en el próximo nivel.
RECUERDA: tienes disponibles todos los niveles para consultarlo y poner seguir trabajando y profundizando. ",null,0,null);

--ACTIVITY
INSERT IGNORE INTO activity_user_question(id,answers,question,parent,type,unique_response,resources,title) VALUES
(1,"Sé que no puedo seguir con este nivel de estrés;Creo que hay cosas más importantes que el consumismo de la vida diaria;No puedo continuar explotando cada vez que algo va mal;Seguir pagando mi malestar con los demás no me lleva a ningún lado;Mi cuerpo está sufriendo las consecuencias de mi ritmo de vida;Necesito aprender a manejar todo este estrés de otra manera;Otros","Marca aquellas casillas que te impulsan a estar aquí:",2,"checkbox",0,null,null),
(2,"Desayuno;Comida de media mañana;Almuerzo;Merienda;Cena;Picoteo","¿Qué comidas has hecho hoy?",4,"checkbox",0,null,null),
(3,"Menos de 0,5 L;Entre 0,5-1 L;Entre 1-1,5 L;Entre 1,5–2 L;Más de 2 L","¿Qué cantidad de agua has bebido hoy?",5,"checkbox",1,null,null),
(4,"Zumos;Refrescos;Bebidas energéticas / estimulantes;Bebidas alcohólicas","¿Has consumido otro tipo de bebidas?",6,"checkbox",0,null,null),
(5,"Menos de 3 h;3 - 4 h;5 - 6 h;7 - 9 h;Más de 9 h","¿Cuántas horas has dormido hoy?",7,"checkbox",1,null,null),
(6,"Pintar;Cantar;Ir de compras;Pasear;Hacer deporte;Meditar;Otros","¿Has realizado algún tipo de “actividad agradable”?",8,"checkbox",0,null,null),
(7,"Quedar a comer o tomar algo;Cita con mi pareja;Dia de playa con amigos;Deporte o actividad colaborativa?;Visitar a familiares;Otros","¿Has realizado algún tipo de “actividad social”?",9,"checkbox",0,null,null),
(8,null,"¿Cómo te has sentido? Escribe algunas emociones que lo reflejen",9,"question",0,null,null),
(9,null,"¿Qué es importante para mí?",13,"question",0,null,null),
(10,null,"¿Qué me haría estar mejor?",13,"question",0,null,null),
(11,null,"¿Por qué quiero lograr esto?",13,"question",0,null,null),
(12,null,"¿Qué pasa ahora que no lo tengo?",13,"question",0,null,null),
(13,null,"¿Qué pasará después de lograrlo?",13,"question",0,null,null),
(14,null,"¿Tienes ya algo en mente?",13,"question",0,null,null),
(15,null,"Anota aquí qué necesitas modificar:",14,"question",0,12,null),
(16,null,"¿NOS PONERLOS EN MARCHA? Para mañana es tarde… comienza ahora mismo con el primer escalón. No tengas prisa pero, cuando lo hayas conseguido, pasa al siguiente. ¡ÁNIMO!",15,"steps",0,13,null),
(17,"Facilidad para respirar (0-10);Concentración durante el ejercicio (0-10);Relajación al acabar (0-10)","Para completar este entrenamiento hazlo una vez al día durante 3 días. Además, completa la sieguente tabla:" ,18,"number",0,null,null),
(18,null,"Mi pensamiento erróneo es",23,"question",0,null,null),
(19,null,"¿Sé con seguridad que pasará y/o que es cierto?",23,"question",0,null,null),
(20,null,"¿Qué pruebas le podría presentar a un juez a favor Y en contra de lo que estoy pensando?",23,"question",0,null,null),
(21,null,"¿Podría haber otra explicación alternativa? Entonces, ¿me puedo quedar, al 100% con lo que estoy pensando?",23,"question",0,null,null),
(22,null,"¿Cuál es la probabilidad, de 0 a 100, de que lo que estoy pensando sea cierto?",23,"question",0,null,null),
(23,null,"¿Mi pensamiento viene impulsado por la emoción que estoy teniendo?",23,"question",0,null,null),
(24,null,"¿Si lo que estoy pensando fuese cierto, podría afrontarlo? ¿Cómo lo manejaría? ¿Podría vivir con ello? ",23,"question",0,null,null),
(25,null,"¿Cómo te sientes? Para “romper el hielo” con las emociones vamos a utilizar un termómetro emocional.\nEste “termómetro” puede ayudarnos a identificar nuestras emociones en función de lo agradable/desagradable que nos parezca y la energía que requiere. Trata de situarse en uno de los cuadrantes en función de cómo te están sintiendo en ese mismo momento. Pulsa sobre uno de los cuadrados en función de donde te sientas.",27,"termo",0,null,null),
(26,null,"SITUACIÓN 1",33,"question",0,null,"Y tú ¿Cómo gestionas tus emociones? ¿Qué estrategias utilizas? ¿Aceptas tus emociones? Completa esta tabla durante 2 días. Debes buscar al menos 2 situaciones al día que te generen algún tipo de emoción: identifica la emoción y observa qué estrategia utilizas. Además, una vez que hayas hecho esto, te retamos a que busques una estrategia alternativa que sea más útil."),
(27,null,"EMOCIÓN 1",33,"question",0,null,null),
(28,null,"ESTRATEGIA 1",33,"question",0,null,null),
(29,null,"RETO: ESTRATEGIA ALTERNATIVA 1",33,"question",0,null,null),
(30,null,"SITUACIÓN 2",33,"question",0,null,null),
(31,null,"EMOCIÓN 2",33,"question",0,null,null),
(32,null,"ESTRATEGIA 2",33,"question",0,null,null),
(33,null,"RETO: ESTRATEGIA ALTERNATIVA 2",33,"question",0,null,null);


