package com.gcchr.system.controllers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractRestHandler
{
    //    @ExceptionHandler(Exception.class)
    //    public @ResponseBody RestResponse handleUncaughtException(Exception ex, WebRequest request, HttpServletResponse response) {
    //        log.info("Converting Uncaught exception to RestResponse : " + ex.getMessage());
    //
    //        response.setHeader("Content-Type", "application/json");
    //        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    //        return new RestResponse("Error occurred", ex.toString());
    //    }
    //
    //    @ExceptionHandler(IllegalArgumentException.class)
    //    public @ResponseBody RestResponse handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request, HttpServletResponse response) {
    //        log.info("Converting IllegalArgumentException to RestResponse : " + ex.getMessage());
    //
    //        response.setHeader("Content-Type", "application/json");
    //        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    //        return new RestResponse("Error occurred", ex.toString());
    //    }
}
