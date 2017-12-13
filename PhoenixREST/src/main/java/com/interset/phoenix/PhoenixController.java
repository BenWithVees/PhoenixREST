package com.interset.phoenix;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoenixController {

	@RequestMapping(value = "/greeting", method=RequestMethod.GET, produces="application/json")
	public String greeting(@RequestParam(value = "timestamp") long timestamp) throws IOException, SQLException {
		return new Phoenix().getHbaseRows(timestamp).toString();
	}
}
 