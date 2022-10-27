import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TicketProvider
{
    public ArrayList<Ticket> getTickets(int raceNumber, GregorianCalendar date, ArrayList<Ticket> ticketBase)
    {
        ArrayList<Ticket> result = new ArrayList<>();
        for (int i = 0; i < ticketBase.size(); i++)
        { // проход по условной базе все билетов
            if (ticketBase.get(i).raceNumber == raceNumber && ticketBase.get(i).date.equals(date))
            { // проверка на совпаление номера рейса и даты с искомыми, добавление в результат при совпадении
                result.add(ticketBase.get(i));
            }
        }
        return result;
    }

    public boolean updateTicketStatus(Ticket ticket)
    { // меняет значение на противоположный. Таким образом, в будущем можно использовать метод для "освобождения места",
        // например, при возврате билета
        ticket.isValid = !ticket.isValid;
        return true;
    }
}
