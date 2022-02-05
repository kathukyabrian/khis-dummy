package hackathon.group4.khis.util;

import lombok.extern.log4j.Log4j2;
import okhttp3.*;

import java.io.IOException;

@Log4j2
public class HttpUtil {

    public static String post(String url, String body,  MediaType mediaType) throws IOException {
        log.debug("Util has received the request");
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(body, mediaType);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try (
                Response response = client.newCall(request).execute();
        )
        {
            return response.body().string();
        }

    }


}
