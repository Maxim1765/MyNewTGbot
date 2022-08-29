import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

    //инлайн хуита
        public InlineKeyboardMarkup inlineKeyboardButton() {

            InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
            InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
            inlineKeyboardButton1.setText("click");

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
}
