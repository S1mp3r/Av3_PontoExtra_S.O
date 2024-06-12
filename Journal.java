import java.time.*;
import java.util.*;
// Caso o import de utils dê problema por conta de uma aplicação antiga, descomente a linha abaixo e comente a linha a cima.
// Descomentar linha 6 e 7.
// Comentar linha 1 e 2.
// import java.util.List;
// import java.time.LocalDateTime;

public class Journal {
    private List<String> log;
    private List<LocalDateTime> dates;

    public Journal() {
        this.log = new ArrayList<>();
        this.dates = new ArrayList<>();
    }

    public void addEntry(String entry) {
        final LocalDateTime datas = LocalDateTime.of(
            LocalDateTime.now().getYear(),
            LocalDateTime.now().getMonth(),
            LocalDateTime.now().getDayOfMonth(),
            LocalDateTime.now().getHour(),
            LocalDateTime.now().getMinute(),
            LocalDateTime.now().getSecond()
        );
        dates.add(datas);
        log.add(entry);
    }

    public void getLogSeparate() {
        Integer index = 0;

        if(!log.isEmpty()) {
            for (String historic : log) {
                System.out.println("Data -> " + this.dates.get(index) + "   ||||||||   Acao -> "+ historic);
                index++;
            }
        }
        if(log.isEmpty())
            System.out.println("Nenhuma acao foi feita ou registrada no momento.");
    }

    public void clearLog() {
        log.clear();
    }
}
