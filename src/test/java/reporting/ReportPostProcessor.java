package reporting;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReportPostProcessor {

    private static final String STATUS_BADGE_CSS =
            ".event-row td:first-child i{display:none;}"
            + ".status-badge{display:inline-block;min-width:46px;padding:2px 8px;"
            + "border-radius:6px;font-size:12px;font-weight:600;text-align:center;color:#fff;}"
            + ".status-info{background:#4d8df7;}"
            + ".status-pass{background:#7ac043;}"
            + ".status-fail{background:#e74c3c;}"
            + ".status-warning{background:#f1c40f;color:#1f2d3d;}"
            + ".status-skip{background:#95a5a6;}"
            + ".status-error{background:#c0392b;}"
            + ".status-fatal{background:#8e44ad;}"
            + ".status-debug{background:#3498db;}";

    public static void addStatusBadges(Path reportPath) {
        if (reportPath == null || !Files.exists(reportPath)) {
            return;
        }
        try {
            String html = new String(Files.readAllBytes(reportPath), StandardCharsets.UTF_8);
            if (!html.contains("status-badge")) {
                html = injectCss(html);
                html = replaceStatusIcons(html);
                Files.write(reportPath, html.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException ignored) {
            // If post-processing fails, keep the original report.
        }
    }

    private static String injectCss(String html) {
        String marker = "<style type=\"text/css\">";
        int idx = html.indexOf(marker);
        if (idx == -1) {
            return html;
        }
        int insertAt = idx + marker.length();
        return html.substring(0, insertAt)
                + STATUS_BADGE_CSS
                + html.substring(insertAt);
    }

    private static String replaceStatusIcons(String html) {
        html = html.replace("<td><i class=\"fa fa-info text-info\"></i></td>",
                "<td><span class=\"status-badge status-info\">Info</span></td>");
        html = html.replace("<td><i class=\"fa fa-check text-pass\"></i></td>",
                "<td><span class=\"status-badge status-pass\">Pass</span></td>");
        html = html.replace("<td><i class=\"fa fa-times text-fail\"></i></td>",
                "<td><span class=\"status-badge status-fail\">Fail</span></td>");
        html = html.replace("<td><i class=\"fa fa-exclamation text-warning\"></i></td>",
                "<td><span class=\"status-badge status-warning\">Warn</span></td>");
        html = html.replace("<td><i class=\"fa fa-angle-double-right text-skip\"></i></td>",
                "<td><span class=\"status-badge status-skip\">Skip</span></td>");
        html = html.replace("<td><i class=\"fa fa-exclamation-circle text-error\"></i></td>",
                "<td><span class=\"status-badge status-error\">Error</span></td>");
        html = html.replace("<td><i class=\"fa fa-exclamation-triangle text-fatal\"></i></td>",
                "<td><span class=\"status-badge status-fatal\">Fatal</span></td>");
        html = html.replace("<td><i class=\"fa fa-bug text-debug\"></i></td>",
                "<td><span class=\"status-badge status-debug\">Debug</span></td>");
        return html;
    }
}
