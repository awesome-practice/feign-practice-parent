package com.practice.springcloud.feign.boot.param_existence;

import com.practice.springcloud.feign.boot.AnnotationHttpbinClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * reproduce 400
 *
 * @author Luo Bao Ding
 * @since 2019/6/1
 */
@RestController
public class ChatController {

    private final AnnotationHttpbinClient annotationHttpbinClient;

    public ChatController(AnnotationHttpbinClient annotationHttpbinClient) {
        this.annotationHttpbinClient = annotationHttpbinClient;
    }

    @RequestMapping(value = "/msgRead", method = RequestMethod.POST)
    @ResponseBody
    public String msgRead(Long fid, Integer msgTime, Long uid, String sign) {
        System.out.println("fid = [" + fid + "], msgTime = [" + msgTime + "], uid = [" + uid + "], sign = [" + sign + "]");

        return annotationHttpbinClient.msgRead(fid, uid, msgTime);
    }
}
