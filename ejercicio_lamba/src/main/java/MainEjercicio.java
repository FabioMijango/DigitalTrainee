import java.util.function.Function;

public class MainEjercicio {
    public static void main(String[] args) {

        Function<String, String> transformacion = frase -> {
            String nuevaFrase = "";
            for(char letra : frase.toCharArray()){
                if(letra == ' ' || letra == '.' || letra == ','){
                    continue;
                }
                nuevaFrase = nuevaFrase.concat(String.valueOf(letra));
            }

            return nuevaFrase.toUpperCase();
        };

        String miFrase = "Hola, que tal estas...";
        System.out.println(transformacion.apply(miFrase));

    }
}
