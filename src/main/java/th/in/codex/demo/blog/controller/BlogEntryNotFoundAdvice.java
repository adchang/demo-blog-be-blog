package th.in.codex.demo.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import th.in.codex.demo.blog.exception.BlogEntryNotFoundException;

@ControllerAdvice
public class BlogEntryNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(BlogEntryNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String employeeNotFoundHandler(BlogEntryNotFoundException e) {
    return "Oops..." + e.getMessage();
  }
}
