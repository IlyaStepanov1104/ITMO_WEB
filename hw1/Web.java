import java.io.IOException;

public class Web {
    public static void main(String[] args) {
        String com = "curl \"http://1d3p.wp.codeforces.com/new\" \\\n" +
                "  -H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9' \\\n" +
                "  -H 'Accept-Language: ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7' \\\n" +
                "  -H 'Cache-Control: max-age=0' \\\n" +
                "  -H 'Connection: keep-alive' \\\n" +
                "  -H 'Content-Type: application/x-www-form-urlencoded' \\\n" +
                "  -H 'Cookie: __utmc=71512449; evercookie_etag=743e0daujf8wg0jgex; evercookie_cache=743e0daujf8wg0jgex; __utmz=71512449.1662907759.48.5.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); evercookie_png=743e0daujf8wg0jgex; 70a7c28f3de=743e0daujf8wg0jgex; __utma=71512449.1781736259.1650470255.1662907759.1663258470.49; JSESSIONID=4FB6E59DD8F204EE42EE3657DE3E7DA2' \\\n" +
                "  -H 'Origin: http://1d3p.wp.codeforces.com' \\\n" +
                "  -H 'Referer: http://1d3p.wp.codeforces.com/' \\\n" +
                "  -H 'Upgrade-Insecure-Requests: 1' \\\n" +
                "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36' \\\n" +
                "  --data-raw '_af=34be50b38beccce4&proof=1&amount=1&submit=Submit' \\\n" +
                "  --compressed \\\n" +
                "  --insecure";
        int perm = 1;
        for (int i = 1; i <= 100; i++) {
            com = com.replace("proof=" + (perm * perm), "proof=" + (i * i));
            com = com.replace("amount=" + (perm), "amount=" + (i));
            try {
                Process process = Runtime.getRuntime().exec(new String[]{"sh", "-c", com});
                process.waitFor();
                process.destroy();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            perm = i;
        }
    }
}

