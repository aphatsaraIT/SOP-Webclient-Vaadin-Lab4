package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;


@Route(value = "/index2")
public class CashierView extends VerticalLayout  {
    private TextField money, thousand, fiveHundred, oneHundred, twenty, ten, five, one;
    private Button cal;

    public CashierView() {
        money = new TextField("เงินทอน");
        money.setPrefixComponent(VaadinIcon.DOLLAR.create());
        cal = new Button("คำนวณเงินทอน");
        thousand = new TextField();
        thousand.setPrefixComponent(new Span("$1000:"));
        fiveHundred = new TextField();
        fiveHundred.setPrefixComponent(new Span("$500:"));
        oneHundred = new TextField();
        oneHundred.setPrefixComponent(new Span("$100:"));
        twenty = new TextField();
        twenty.setPrefixComponent(new Span("$20:"));
        ten = new TextField();
        ten.setPrefixComponent(new Span("$10:"));
        five = new TextField();
        five.setPrefixComponent(new Span("$5:"));
        one = new TextField();
        one.setPrefixComponent(new Span("$1:"));
        add(money, cal, thousand, fiveHundred, oneHundred, twenty, ten, five, one);


        cal.addClickListener(event -> {
            int n1 = Integer.parseInt(money.getValue());

            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/"+n1)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();

            thousand.setValue(String.valueOf(out.getB1000()));
            fiveHundred.setValue(String.valueOf(out.getB500()));
            oneHundred.setValue(String.valueOf(out.getB100()));
            twenty.setValue(String.valueOf(out.getB20()));
            ten.setValue(String.valueOf(out.getB10()));
            five.setValue(String.valueOf(out.getB5()));
            one.setValue(String.valueOf(out.getB1()));


        });
    }

}
