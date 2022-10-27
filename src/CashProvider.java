import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CashProvider
{
    public long cardNumber; // card
    public boolean isAuthorization;
    public int balance; // баланс средств на карте
    public int sellerBalance; // баланс продавца
    TicketProvider ticketProvider;

    public CashProvider(long cardNumber, int balance, int sellerBalance)
    {
        this.cardNumber = cardNumber;
        this.isAuthorization = false;
        this.balance = balance;
        this.sellerBalance = sellerBalance;
        this.ticketProvider = new TicketProvider();
    }

    public void buy(Ticket ticket)
    {
        if (isAuthorization)
        { // вычитает стиомсть билета с баланса покупателя, и переводит стоимость на баланс продавца,
          // обновляет валидность билета
            balance -= ticket.price;
            sellerBalance += ticket.price;
            ticketProvider.updateTicketStatus(ticket);
        } else System.out.println("Need your authorization for the operation.");
    }

    public void authorization(Customer customer) throws IOException
    { // запрашиваем id для авторизации, считываем, проверяем, выполняем авторизацию. В будущем метод можно использовать
        // для деавторизации
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the id for authorization: ");
        int request = Integer.parseInt(reader.readLine());
        if (request == customer.id)
        {
           isAuthorization = !isAuthorization;
        }
    }
}
