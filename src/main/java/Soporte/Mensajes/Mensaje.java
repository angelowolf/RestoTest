package Soporte.Mensajes;

import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

/**
 * @author angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:28 p.m.
 */
public abstract class Mensaje {

    protected String HACE;
    protected String YEAR;
    protected String YEARS;
    protected String MASDE;
    protected String MES;
    protected String MESES;
    protected String DIA;
    protected String DIAS;
    protected String HORA;
    protected String HORAS;
    protected String MINUTO;
    protected String MINUTOS;
    protected String SEGUNDO;
    protected String SEGUNDOS;
    protected String HACEUNINSTANTE;
    // ***********************************************************************
    public String FECHAJSON;
    public String FECHAHORAJSON;

    protected String MODIFICADO;
    protected String MODIFICADA;
    protected String RECUPERADO;
    protected String RECUPERADA;
    protected String AGREGADO;
    protected String AGREGADA;
    protected String ELIMINADO;
    protected String ELIMINADA;
    protected String BAJA;
    protected String BAJO;
    protected String ELEXISTE;
    protected String USADOPORUNA;
    protected String USADOPORUN;
    protected String USADAPORUNA;
    protected String USADAPORUN;
    protected String USADOPORUNAAMBOS;
    protected String USADOPORUNAMBOS;
    protected String USADAPORUNAAMBOS;
    protected String USADAPORUNAMBOS;
    protected String CODIGOYAENVIADO;
    protected String NOTIFICACIONINSUMO;
    public String PREGUNTADARBAJAEL;
    public String PREGUNTADARBAJALA;
    public String PREGUNTARECUPERAREL;
    public String PREGUNTARECUPERARLA;
    public String PREGUNTAELIMINAREL;
    public String PREGUNTAELIMINARLA;
    //************************************************************************//
    //Nombre de clases...//
    public String USUARIO;
    public String INSUMO;
    public String CATEGORIAINSUMO;
    public String NOTIFICACION;
    public String RECETA;
    public String CATEGORIARECETA;
    public String INSUMOELABORADO;
    public String NOMBRE;

    //************************************************************************//
    public String TIPOSUCCESS = "success";
    public String TIPOINFO = "info";
    public String TIPOWARNING = "warning";
    public String TIPODANGER = "danger";
    //************************************************************************//
    //Mensajes de validacion//
    public String INGRESECLAVE;
    public String INGRESECLAVEACTUAL;
    public String INGRESEPRECIO;
    public String INGRESEVALORPOSITIVO;
    public String INGRESERESPUESTA;
    public String INGRESECANTIDADCOMPRADA;
    public String INGRESECANTIDADAJUSTADA;
    public String INGRESEINSUMO;
    public String INGRESECANTIDADUTILIZAR;
    public String OBLIGATORIO;
    public String SELECCIONEUNIDADMEDIDA;
    public String SELECCIONEPREGUNTA;
    public String SELECCIONECATEGORIAINSUMO;
    public String SELECCIONEINSUMO;
    public String IDINVALIDO;
    public String ERRORVALIDAR;
    public String REPITACLAVE;
    public String CLAVEINGRESADAMAL;
    public String CLAVENOCOINCIDE;
    public String CLAVECAMBIADA;
    public String CLAVERESETEADA;
    public String RESPUESTANOVALIDA;
    public String NICKINCORRECTO;
    public String COMPRAREGISTRADA;
    public String AJUSTEREALIZADO;
    public String NOTIFICACIONVISTA;
    public String FECHAINVALIDA;
    public String INGRESECANTIDADCONFECCIONAR;
    public String SELECCIONENOTIFICACION;
    public String NOTIFICACIONESELIMINADAS;
    public String NOTIFICACIONESVISTAS;
    public String CONFECCIONREGISTRADA;
    public String SELECCIONECATEGORIARECETA;

    /**
     * Crea un mensaje con el tiempo pasado por parametro. "Ya se ha enviado un
     * email con el código a la dirección ingresada. En %d minutos podra generar
     * otro código."
     *
     * @param arg El tiempo.
     * @return EL mensaje.
     */
    public String getCodigoYaEnviado(long arg) {
        return String.format(CODIGOYAENVIADO, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto fue modificado. "El %s ha sido
     * modificado con éxito.";
     *
     * @param arg El objeto.
     * @return El mensaje.
     */
    public String getModificado(String arg) {
        return String.format(MODIFICADO, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto fue modificado. "La %s ha sido
     * modificada con éxito.";
     *
     * @param arg El objeto.
     * @return El mensaje.
     */
    public String getModificada(String arg) {
        return String.format(MODIFICADA, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto fue agregado. "El %s ha sido
     * agregado.";
     *
     * @param arg El objeto.
     * @return El mensaje.
     */
    public String getAgregado(String arg) {
        return String.format(AGREGADO, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto fue agregado. "La %s ha sido
     * agregada.";
     *
     * @param arg El objeto.
     * @return El mensaje.
     */
    public String getAgregada(String arg) {
        return String.format(AGREGADA, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto fue eliminado. "El %s ha sido
     * eliminado.";
     *
     * @param arg El objeto.
     * @return El mensaje.
     */
    public String getEliminado(String arg) {
        return String.format(ELIMINADO, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto fue eliminado. "La %s ha sido
     * eliminado.";
     *
     * @param arg El objeto.
     * @return El mensaje.
     */
    public String getEliminada(String arg) {
        return String.format(ELIMINADA, arg);
    }

    /**
     * Crea un mensaje que notifica que el nombre ingresado ya esta ocupado.
     * "Este %s ya esta en uso."
     *
     * @param arg El objeto usado.
     * @return El mensaje.
     */
    public String getExiste(String arg) {
        return String.format(ELEXISTE, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto no se puede eliminar porque
     * está siendo usado. "El %s está siendo utilizado por alguna %s, debe
     * desvincularlos para continuar"
     *
     * @param arg El objeto usado.
     * @param arg2 Quien usa al objeto.
     * @return El mensaje.
     */
    public String getUsadoPorUnaDesvincular(String arg, String arg2) {
        return String.format(USADOPORUNA, arg, arg2);
    }

    /**
     * Crea un mensaje que notifica que el objeto no se puede eliminar porque
     * está siendo usado. "La %s está siendo utilizada por alguna %s, debe
     * desvincularlas para continuar"
     *
     * @param arg El objeto usado.
     * @param arg2 Quien usa al objeto.
     * @return El mensaje.
     */
    public String getUsadaPorUnaDesvincular(String arg, String arg2) {
        return String.format(USADAPORUNA, arg, arg2);
    }

    /**
     * Crea un mensaje que notifica que el objeto no se puede eliminar porque
     * está siendo usado. "El %s está siendo utilizado por algun %s, debe
     * desvincularlos para continuar"
     *
     * @param arg El objeto usado.
     * @param arg2 Quien usa al objeto.
     * @return El mensaje.
     */
    public String getUsadoPorUnDesvincular(String arg, String arg2) {
        return String.format(USADOPORUN, arg, arg2);
    }

    /**
     * Crea un mensaje que notifica que el objeto no se puede eliminar porque
     * está siendo usado. "La %s está siendo utilizada por algun %s, debe
     * desvincularlos para continuar"
     *
     * @param arg El objeto usado.
     * @param arg2 Quien usa al objeto.
     * @return El mensaje.
     */
    public String getUsadaPorUnDesvincular(String arg, String arg2) {
        return String.format(USADAPORUN, arg, arg2);
    }

    /**
     * Crea un mensaje que notifica que el objeto no se puede eliminar porque
     * está siendo usado. "El %s está siendo utilizado por alguna %s, debe darla
     * de baja o desvincularlas para continuar"
     *
     * @param arg El objeto usado.
     * @param arg2 Quien usa al objeto.
     * @return El mensaje.
     */
    public String getUsadoPorUnaAmbos(String arg, String arg2) {
        return String.format(USADOPORUNAAMBOS, arg, arg2);
    }

    /**
     * Crea un mensaje que notifica que el objeto no se puede eliminar porque
     * está siendo usado. "La %s está siendo utilizada por alguna %s, debe darla
     * de baja o desvincularlas para continuar"
     *
     * @param arg El objeto usado.
     * @param arg2 Quien usa al objeto.
     * @return El mensaje.
     */
    public String getUsadaPorUnaAmbos(String arg, String arg2) {
        return String.format(USADAPORUNAAMBOS, arg, arg2);
    }

    /**
     * Crea un mensaje que notifica que el objeto no se puede eliminar porque
     * está siendo usado. "El %s está siendo utilizado por algun %s, debe darlo
     * de baja o desvincularlos para continuar"
     *
     * @param arg El objeto usado.
     * @param arg2 Quien usa al objeto.
     * @return El mensaje.
     */
    public String getUsadoPorUnAmbos(String arg, String arg2) {
        return String.format(USADOPORUNAMBOS, arg, arg2);
    }

    /**
     * Crea un mensaje que notifica que el objeto no se puede eliminar porque
     * está siendo usado. "La %s está siendo utilizada por algun %s, debe darlo
     * de baja o desvincularlos para continuar"
     *
     * @param arg El objeto usado.
     * @param arg2 Quien usa al objeto.
     * @return El mensaje.
     */
    public String getUsadaPorUnAmbos(String arg, String arg2) {
        return String.format(USADAPORUNAMBOS, arg, arg2);
    }

    /**
     * Crea un mensaje que pregunta si el objeto quiere ser eliminado. "¿Está
     * seguro de que quiere dar de baja este %s?"
     *
     * @param arg
     * @return
     */
    public String getPreguntaDarBajaEl(String arg) {
        return String.format(PREGUNTADARBAJAEL, arg);
    }

    /**
     * Crea un mensaje que pregunta si el objeto quiere ser eliminado. "¿Está
     * seguro de que quiere dar de baja esta %s?"
     *
     * @param arg
     * @return
     */
    public String getPreguntaDarBajaLa(String arg) {
        return String.format(PREGUNTADARBAJALA, arg);
    }

    /**
     * Crea un mensaje que pregunta si el objeto quiere ser eliminado. "¿Está
     * seguro de que quiere eliminar este %s?"
     *
     * @param arg
     * @return
     */
    public String getPreguntaEliminarEl(String arg) {
        return String.format(PREGUNTAELIMINAREL, arg);
    }

    /**
     * Crea un mensaje que pregunta si el objeto quiere ser eliminado. "¿Está
     * seguro de que quiere eliminar esta %s?"
     *
     * @param arg
     * @return
     */
    public String getPreguntaEliminarLa(String arg) {
        return String.format(PREGUNTAELIMINARLA, arg);
    }

    /**
     * Crea un mensaje que pregunta si el objeto quiere ser eliminado. "¿Está
     * seguro de que quiere recuperar esta %s?"
     *
     * @param arg
     * @return
     */
    public String getPreguntaRecuperarLa(String arg) {
        return String.format(PREGUNTARECUPERARLA, arg);
    }

    /**
     * * Crea un mensaje que pregunta si el objeto quiere ser eliminado. "¿Está
     * seguro de que quiere recuperar este %s?"
     *
     *  * @param arg
     * @return
     */
    public String getPreguntaRecuperarEl(String arg) {
        return String.format(PREGUNTARECUPERAREL, arg);
    }

    /**
     * * Crea un mensaje: "El insumo %s esta debajo del minimo".
     *
     * @param arg
     * @return
     */
    public String getNotificacionInsumo(String nombre) {
        return String.format(NOTIFICACIONINSUMO, nombre);
    }

    /**
     * Crea un mensaje: "La %s ha sido dado de baja con éxito.";
     *
     * @param arg
     * @return
     */
    public String getBaja(String arg) {
        return String.format(BAJA, arg);
    }

    /**
     * Crea un mensaje: "El %s ha sido dado de baja con éxito.";
     *
     * @param arg
     * @return
     */
    public String getBajo(String arg) {
        return String.format(BAJO, arg);
    }

    /**
     * Crea un mensaje: "El %s ha sido recuperado con éxito.";
     *
     * @param arg
     * @return
     */
    public String getRecuperado(String arg) {
        return String.format(RECUPERADO, arg);
    }

    /**
     * Crea un mensaje: "La %s ha recuperada con éxito.";
     *
     * @param arg
     * @return
     */
    public String getRecuperada(String arg) {
        return String.format(RECUPERADA, arg);
    }

    public String getFechaHumana(LocalDateTime fechaOriginal) {
        LocalDateTime ahora = new LocalDateTime();
        Period period = new Period(fechaOriginal, ahora);
        StringBuilder cantidad = new StringBuilder(HACE);

        if (period.getYears() >= 1) {
            PeriodFormatter formatter = new PeriodFormatterBuilder()
                    .appendYears().appendSuffix(YEAR, YEARS)
                    .printZeroNever()
                    .toFormatter();
            cantidad.append(MASDE);
            cantidad.append(formatter.print(period));
            return cantidad.toString();
        }
        if (period.getMonths() >= 1) {
            PeriodFormatter formatter = new PeriodFormatterBuilder()
                    .appendMonths().appendSuffix(MES, MESES)
                    .printZeroNever()
                    .toFormatter();
            cantidad.append(MASDE);
            cantidad.append(formatter.print(period));
            return cantidad.toString();
        }
        if (period.getDays() >= 1) {
            PeriodFormatter formatter = new PeriodFormatterBuilder()
                    .appendDays().appendSuffix(DIA, DIAS)
                    .printZeroNever()
                    .toFormatter();
            cantidad.append(formatter.print(period));
            return cantidad.toString();
        }
        if (period.getHours() >= 1) {
            PeriodFormatter formatter = new PeriodFormatterBuilder()
                    .appendHours().appendSuffix(HORA, HORAS)
                    .printZeroNever()
                    .toFormatter();
            cantidad.append(formatter.print(period));
            return cantidad.toString();
        }
        if (period.getMinutes() >= 1) {
            PeriodFormatter formatter = new PeriodFormatterBuilder()
                    .appendMinutes().appendSuffix(MINUTO, MINUTOS)
                    .printZeroNever()
                    .toFormatter();
            cantidad.append(formatter.print(period));
            return cantidad.toString();
        }
        if (period.getSeconds() >= 1) {
            PeriodFormatter formatter = new PeriodFormatterBuilder()
                    .appendSeconds().appendSuffix(SEGUNDO, SEGUNDOS)
                    .printZeroNever()
                    .toFormatter();
            cantidad.append(formatter.print(period));
            return cantidad.toString();
        }
        return HACEUNINSTANTE;
    }
}//end Mensaje
