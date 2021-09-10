package com.example.demo_telegram_bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@PropertySource("classpath:telegram.properties")
public class MyBot extends TelegramLongPollingBot {
    @Value("${bot.name}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    @Override
    public String getBotToken() {
        System.out.println(botToken);
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            System.out.println(".....................................");
            final String text = update.getMessage().getText();
            final long chatId = update.getMessage().getChatId();
            System.out.println(text+" - from - " + chatId);
        }
        
    }

    @Override
    public String getBotUsername() {
        System.out.println(botName);
        return botName;
    }

}
