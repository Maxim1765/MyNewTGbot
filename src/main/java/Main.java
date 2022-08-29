import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.printf("bot started");
            TelegramBotMananger telegramBotMananger = new TelegramBotMananger();
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new TelegramBotMananger());
        }catch (TelegramApiException e){
            System.out.printf("bot is not started");
        }
    }
}
