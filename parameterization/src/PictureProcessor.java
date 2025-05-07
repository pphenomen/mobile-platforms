import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Picture {
    String name;
    String theme;
    int r, g, b;

    Picture(String name, String theme, int r, int g, int b) {
        this.name = name;
        this.theme = theme;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public String toString() {
        return name + " (" + theme + ") - RGB(" + r + "," + g + "," + b + ")";
    }
}

public class PictureProcessor {
    public static void main(String[] args) {
        List<Picture> pictures = Arrays.asList(
                new Picture("OceanView", "море", 100, 150, 200),
                new Picture("SeaShell", "море", 80, 120, 180),
                new Picture("GreenForest", "лес", 40, 200, 50),
                new Picture("CityLights", "город", 200, 200, 210),
                new Picture("RoseGarden", "цветы", 255, 100, 150),
                new Picture("MountainLake", "лес", 30, 100, 70)
        );

        // Параметры фильтра
        int minR = 50, maxR = 255;
        int minG = 100, maxG = 210;
        int minB = 70, maxB = 200;

        // Предикат
        Predicate<Picture> colorInRange = pic ->
                pic.r >= minR && pic.r <= maxR &&
                        pic.g >= minG && pic.g <= maxG &&
                        pic.b >= minB && pic.b <= maxB;

        // Группировка по темам
        Map<String, List<Picture>> grouped = pictures.stream()
                .collect(Collectors.groupingBy(pic -> pic.theme));

        for (String theme : grouped.keySet()) {
            System.out.println("\nТема: " + theme);
            List<Picture> group = grouped.get(theme).stream().sorted(Comparator.comparing(p -> p.name)).collect(Collectors.toList());

            group.forEach(System.out::println);

            // Лямбды
            Picture maxRPic = group.stream().max(Comparator.comparingInt(p -> p.r)).orElse(null);
            Picture minRPic = group.stream().min(Comparator.comparingInt(p -> p.r)).orElse(null);
            Picture maxGPic = group.stream().max(Comparator.comparingInt(p -> p.g)).orElse(null);
            Picture minGPic = group.stream().min(Comparator.comparingInt(p -> p.g)).orElse(null);
            Picture maxBPic = group.stream().max(Comparator.comparingInt(p -> p.b)).orElse(null);
            Picture minBPic = group.stream().min(Comparator.comparingInt(p -> p.b)).orElse(null);

            System.out.println("Макс R: " + maxRPic);
            System.out.println("Мин R: " + minRPic);
            System.out.println("Макс G: " + maxGPic);
            System.out.println("Мин G: " + minGPic);
            System.out.println("Макс B: " + maxBPic);
            System.out.println("Мин B: " + minBPic);

            // Фильтрация по диапазону
            List<Picture> inRange = group.stream().filter(colorInRange).collect(Collectors.toList());

            System.out.println("Картинки в диапазоне RGB:");
            inRange.forEach(System.out::println);
        }
    }
}
