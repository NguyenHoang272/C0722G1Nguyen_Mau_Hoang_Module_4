package dictionary.service;

import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService{
    @Override
    public String search(String word) {
        final String[] english = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        final String[] vietnamese = {"một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín", "mười"};
        int index = -1;
        for (int i = 0; i < english.length; i++) {
            if (english[i].equals(word)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return "Không có trong từ điển";
        }
        return vietnamese[index];
    }
}
