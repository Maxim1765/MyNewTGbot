import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TelegramBotMananger extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "valueSHAR_bot";
    }

    @Override
    public String getBotToken() {
        return "5539736199:AAGmuPWnpAXdWKlzup1So5PsykS7Uc7PuZs";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            String messageFromBot = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            if (messageFromBot.equals("/start")) {
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("выоаывф");
                message.setReplyMarkup(inlineKeyboardButton());
                try {
                    execute (message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } else if (update.hasCallbackQuery()) {
            String callbackDataFromBot = update.getCallbackQuery().getData();
            int messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();

           // botMultiLevelMenuLogic.callMethodByName(callbackDataFromBot, this, chatId, messageId);

            InlineKeyboardMarkup inlineKeyboardMarkup = null;
            String text = "";

            switch (callbackDataFromBot) {
                case "click1":
                    text = "click main1";
                    inlineKeyboardMarkup = gotoRight();
                    break;

                case "click2":
                    text = "click main2";
                    inlineKeyboardMarkup = gotoLeft();
                    break;
            }

            EditMessageText message = new EditMessageText();
            message.setChatId(chatId);
            message.setMessageId(messageId);
            message.setText(text);
            message.setReplyMarkup(inlineKeyboardMarkup);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
    }

    //инлайн хуита
    public InlineKeyboardMarkup inlineKeyboardButton() {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("click1");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("click2");

        List<InlineKeyboardButton> rowLiist = new ArrayList<>();
        List<List<InlineKeyboardButton>> listList = new ArrayList<>();

        rowLiist.add(inlineKeyboardButton1);
        rowLiist.add(inlineKeyboardButton2);

        listList.add(rowLiist);

        inlineKeyboardMarkup.setKeyboard(listList);

        return inlineKeyboardMarkup;
    }


    //обычная хуита
    public ReplyKeyboardMarkup keyboardButtons (){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add("click");

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add("click");

        ArrayList<KeyboardRow> rowArray = new ArrayList<>();
        rowArray.add(keyboardRow1);
        rowArray.add(keyboardRow2);

        replyKeyboardMarkup.setKeyboard(rowArray);

        return replyKeyboardMarkup;
    }

    public InlineKeyboardMarkup gotoRight() {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("goto");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("right");

        List<InlineKeyboardButton> rowLiist = new ArrayList<>();
        List<List<InlineKeyboardButton>> listList = new ArrayList<>();

        rowLiist.add(inlineKeyboardButton1);
        rowLiist.add(inlineKeyboardButton2);

        listList.add(rowLiist);

        inlineKeyboardMarkup.setKeyboard(listList);

        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup gotoLeft() {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("goto");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("left");

        List<InlineKeyboardButton> rowLiist = new ArrayList<>();
        List<List<InlineKeyboardButton>> listList = new ArrayList<>();

        rowLiist.add(inlineKeyboardButton1);
        rowLiist.add(inlineKeyboardButton2);

        listList.add(rowLiist);

        inlineKeyboardMarkup.setKeyboard(listList);

        return inlineKeyboardMarkup;
    }





//        if (update.hasMessage() && update.getMessage().hasText()) {
////
////            String messageFromBot = update.getMessage().getText();
////            long chat_id = update.getMessage().getChatId();
////
////            if (messageFromBot.equals("/start")) {
////                try {
////                    SendPhoto sendPhoto = new SendPhoto();
////
////                    InputFile inputFile = new InputFile(new File("C:\\Users\\admin\\Desktop\\kHods9mpIWc.jpg"));
////
////                    sendPhoto.setChatId(chat_id);
////                    sendPhoto.setPhoto(inputFile);
////
////                    execute(sendPhoto);
////                } catch (TelegramApiException e) {
////                    e.printStackTrace();
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
////            }
////        }




    }




