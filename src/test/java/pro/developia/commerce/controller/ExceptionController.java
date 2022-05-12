package pro.developia.commerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.developia.commerce.core.ApiResult;

@RequestMapping("/test/exception")
@RestController
public class ExceptionController {

    @GetMapping("/{id}")
    public ApiResult<Void> testException(@PathVariable int id) {
        if (id == 1) {
            throw new NullPointerException();
        }
        return ApiResult.ok();
    }
}