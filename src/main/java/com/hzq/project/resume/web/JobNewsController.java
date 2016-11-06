package com.hzq.project.resume.web;

import com.hzq.project.resume.dao.entity.JobNews;
import com.hzq.project.resume.service.JobNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hzq on 16/9/22.
 */
@RestController
@RequestMapping(path = "jobNews")
public class JobNewsController {
    @Autowired
    private JobNewsService jobNewsService;

    @RequestMapping(path = "getJobNews", method = RequestMethod.GET)
    public List<JobNews> getJobNews() {
        return jobNewsService.getJobNews();
    }

    @RequestMapping(path = "getJobNewsDetail/{id}", method = RequestMethod.GET)
    public JobNews getJobNewsDetail(@PathVariable Integer id) {
        return jobNewsService.getJobNewsDetail(id);
    }

}
