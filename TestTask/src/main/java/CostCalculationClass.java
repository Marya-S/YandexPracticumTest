import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CostCalculationClass {
    public static float calcCost(int distance, boolean size, boolean fragility, Load load) throws Exception {
        float coast = 0;
        if(fragility){
            if (distance > 30){
                throw new Exception("Нельзя доставить хрупкий товар дальше 30 км.");
            }
            else {
                coast += 300;
            }
        }
        if(distance >= 30) {coast += 300;}
        else if(distance >=10 && distance<30) {coast += 200;}
        else if(distance >= 2 && distance < 10) {coast +=100;}
        else if(distance>0 && distance<2){coast+=50;}
        else {throw new Exception("Введена некорректная дистанция");}
        if(size){coast+=200;}
        else {coast+=100;}
        switch (load){
            case VERY_HIGH: coast*=1.6; break;
            case HIGH: coast *=1.4; break;
            case ELEVATED: coast*=1.2; break;
            case OTHER:coast*=1; break;
        }
        if(coast<400){return 400;}
        return coast;
    }

    //Проверка работы функции
 /**   public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите параметры заказа '/n Расстояние:");
        int distance = Integer.parseInt(reader.readLine());
        System.out.println("Посылка большая? (true/false)");
        boolean size = Boolean.parseBoolean(reader.readLine());
        System.out.println("Посылка хрупкая? (true/false)");
        boolean fragility = Boolean.parseBoolean(reader.readLine());
        System.out.println("Укажите тип загрузки службы доставки: (VERY_HIGH,HIGH,ELEVATED,OTHER)");
        Load load = Load.valueOf(reader.readLine());
        try{
            float result = calcCost(distance,size,fragility,load);
            System.out.println("Итоговая стоимость доставки: "+ result);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    } **/
}

