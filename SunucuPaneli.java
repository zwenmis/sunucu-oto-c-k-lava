import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class DiscordBotPanel {

    public static void main(String[] args) throws LoginException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bot token'ınızı girin: ");
        String token = scanner.nextLine();

        JDA jda = JDABuilder.createDefault(token).build();
        jda.awaitReady();

        while (true) {
            System.out.println("1. Tüm sunuculardan çık");
            System.out.println("2. Sunucuları listele");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    for (Guild guild : jda.getGuilds()) {
                        System.out.println("Çıkılıyor: " + guild.getName());
                        guild.leave().queue();
                    }
                    System.out.println("Tüm sunuculardan çıkıldı.");
                    break;

                case 2:
                    for (Guild guild : jda.getGuilds()) {
                        System.out.println("Sunucu: " + guild.getName());
                    }
                    break;

                case 3:
                    System.out.println("Çıkılıyor...");
                    jda.shutdownNow();
                    return;

                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }
}
