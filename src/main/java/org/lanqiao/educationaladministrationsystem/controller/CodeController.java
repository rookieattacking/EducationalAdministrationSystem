package org.lanqiao.educationaladministrationsystem.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@RestController
public class CodeController {

    @GetMapping("/code")  // 改用 GetMapping
    public void code(HttpServletResponse response, HttpServletRequest request) throws IOException {
        // 设置响应类型
        response.setContentType("image/jpeg");

        // 允许跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "*");

        // 禁用缓存
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        try {
            // 创建图像
            int width = 120;
            int height = 40;
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();

            // 设置背景
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);

            // 生成验证码
            String code = generateCode();

            // 绘制验证码
            g.setFont(new Font("Arial", Font.BOLD, 30));
            for (int i = 0; i < code.length(); i++) {
                g.setColor(new Color(new Random().nextInt(255),
                        new Random().nextInt(255),
                        new Random().nextInt(255)));
                g.drawString(String.valueOf(code.charAt(i)), 20 + i * 25, 30);
            }

            // 添加干扰线
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                g.setColor(new Color(random.nextInt(255),
                        random.nextInt(255),
                        random.nextInt(255)));
                g.drawLine(random.nextInt(width), random.nextInt(height),
                        random.nextInt(width), random.nextInt(height));
            }

            // 保存验证码到session
            request.getSession().setAttribute("code", code);

            // 输出图像
            g.dispose();
            ImageIO.write(image, "JPEG", response.getOutputStream());
            response.getOutputStream().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 生成随机验证码
    private String generateCode() {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}