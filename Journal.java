import java.time.*;
import java.util.*;
// Caso o import de utils dê problema por conta de uma aplicação antiga, descomente a linha abaixo e comente a linha a cima.
// Descomentar linha 6 e 7.
// Comentar linha 1 e 2.
// import java.util.List;
// import java.time.LocalDate;

public class Journal {
    private List<String> log;
    private List<LocalDate> dates;

    public Journal() {
        this.log = new ArrayList<>();
        this.dates = new ArrayList<>();
    }

    public void addEntry(String entry) {
        final LocalDate date = LocalDate.now();

        dates.add(date);
        log.add(entry);
    }

    public List<String> getLog() {
        return log;
    }

    public void getLogSeparate() {
        Integer index = 0;

        for (String historic : log) {
            System.out.println("Horario -> " + this.dates.get(index) + "   ||||||||   Acao -> "+ historic);
            index++;
        }
    }

    public void clearLog() {
        log.clear();
    }
}
