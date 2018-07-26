package us.bojie.springguice;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.annotation.WebFilter;

@WebFilter
public class SpringAwareGuiceFilter extends GuiceFilter {
}
