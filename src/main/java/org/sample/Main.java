package org.sample;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    private final static String MODEL = "gemma-3-12b-it";

    public static void main(String[] args) {
        // .envからAPIキーを取得
        Dotenv dotenv = Dotenv.load();
        final String API_KEY = dotenv.get("API_KEY");

        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(API_KEY)
                .modelName(MODEL)
                .build();

        String message = "あなたとGeminiとの違いはなんですか？";
        System.out.println("プロンプト： " + message);
        System.out.println("\n=======\n");

        String response = model.chat(message);
        System.out.println(response);
    }
}
