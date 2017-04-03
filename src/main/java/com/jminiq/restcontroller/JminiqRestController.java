package com.jminiq.restcontroller;

import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("v1")
public class JminiqRestController {

  private static final Logger LOG = LoggerFactory.getLogger(JminiqRestController.class);
  
  private Hashtable<String, Object> jqueue = new Hashtable<>();
  /**
   * @return response
   */
  @RequestMapping(value = "/{key}/{value}", method = RequestMethod.PUT)
  public ResponseEntity<Object> jput(@PathVariable("key") String key, @PathVariable("value") String value) {
    LOG.info("recieved msg: {}", key);
    jqueue.put(key, value);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * @return response
   */
  @RequestMapping(value = "/{key}", method = RequestMethod.GET)
  public ResponseEntity<Object> jget(@PathVariable("key") String key) {
    LOG.info("recieved msg: {}", key);
    Object msg = jqueue.get(key);
    return new ResponseEntity<>(msg, HttpStatus.OK);
  }


}
