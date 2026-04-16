package com.example.docker.data;


import com.example.docker.model.Question;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class QuizData {

    public List<Question> getQuestions() {
        return Arrays.asList(
                new Question(1, "Zor bir durumda ne yaparsın?", Arrays.asList(
                        new Question.Answer("Önceden detaylı plan yaparım", "MICHAEL"),
                        new Question.Answer("Güvendiğim birine danışırım", "LINCOLN"),
                        new Question.Answer("Komik bir şey söyleyip ortamı yumuşatırım", "SUCRE"),
                        new Question.Answer("Kendi çıkarıma göre hareket ederim", "TBAG")
                )),
                new Question(2, "Arkadaşın için ne kadar fedakarlık yaparsın?", Arrays.asList(
                        new Question.Answer("Her şeyimi veririm, sınırım yok", "LINCOLN"),
                        new Question.Answer("Akıllıca plan yapar, riski minimize ederim", "MICHAEL"),
                        new Question.Answer("Elimden geleni yaparım ama ailem önce gelir", "SUCRE"),
                        new Question.Answer("Bana ne faydası var önce ona bakarım", "TBAG")
                )),
                new Question(3, "Basınç altında nasıl çalışırsın?", Arrays.asList(
                        new Question.Answer("Soğukkanlılıkla, her detayı kontrol ederim", "MICHAEL"),
                        new Question.Answer("İçgüdülerimle, hızlı karar alırım", "LINCOLN"),
                        new Question.Answer("Stres altında bile pozitif kalmaya çalışırım", "SUCRE"),
                        new Question.Answer("Durumu manipüle ederek avantaj sağlarım", "TBAG")
                )),
                new Question(4, "Seni en iyi tanımlayan özellik hangisi?", Arrays.asList(
                        new Question.Answer("Zeka ve mühendislik düşüncesi", "MICHAEL"),
                        new Question.Answer("Güç ve kararlılık", "LINCOLN"),
                        new Question.Answer("Sadakat ve neşe", "SUCRE"),
                        new Question.Answer("Hayatta kalma içgüdüsü", "TBAG")
                )),
                new Question(5, "Bir sorunla karşılaştığında ilk tepkin ne olur?", Arrays.asList(
                        new Question.Answer("Sistematik analiz ederim, çözüm üretirim", "MICHAEL"),
                        new Question.Answer("Doğrudan üstüne giderim", "LINCOLN"),
                        new Question.Answer("Çevremdekilerden yardım isterim", "SUCRE"),
                        new Question.Answer("Nasıl fırsat yaratabilirim diye düşünürüm", "TBAG")
                ))
        );
    }

    public Map<String, QuizData.CharacterInfo> getCharacters() {
        return Map.of(
                "MICHAEL", new CharacterInfo(
                        "Michael Scofield",
                        "Dahi mühendis! Her şeyi önceden planlarsın, detaylara takıntılısın ve sevdiklerin için her şeyi göze alırsın. Vücuduna dövme yaptırmayı düşünüyor musun? 😄",
                        "Zeki, planlayıcı, fedakar"
                ),
                "LINCOLN", new CharacterInfo(
                        "Lincoln Burrows",
                        "Güçlü ve kararlısın! Doğrudan, dürüst ve bağlılığına değer verirsin. Bazen düşünmeden hareket etsen de kalbin her zaman doğru yerde.",
                        "Güçlü, sadık, kararlı"
                ),
                "SUCRE", new CharacterInfo(
                        "Fernando Sucre",
                        "Sadık dost! Herkese iyi davranırsın, pozitif enerjinle ortamı aydınlatırsın. Aşk seni her zaman motive eder. ¡Papi! harikasın ",
                        "Neşeli, sadık, sevgi dolu"
                ),
                "TBAG", new CharacterInfo(
                        "Theodore 'T-Bag' Bagwell",
                        "Hayatta kalmayı bilirsin! Kendi çıkarlarını ön planda tutarsın, manipülatif bir zekan var. Belki biraz daha empati geliştirme vakti? 😅 kendini çok düşünürsün",
                        "Kurnaz, hayatta kalma odaklı"
                )
        );
    }

    public record CharacterInfo(String name, String description, String traits) {}
}