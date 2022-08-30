package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@Route(value = "/index1")
public class view01 extends VerticalLayout {
    private TextField num1,num2, ans;
    private Button btnPlus, btnMinus, btnMulti, btnDivide, btnMod, btnMax;
    public view01(){
        num1 = new TextField("Number 1");
        num2 = new TextField("Number 2");
        btnPlus = new Button("+");
        btnMinus = new Button("-");
        btnMulti = new Button("x");
        btnDivide =  new Button("/");
        btnMod = new Button("Mod");
        btnMax = new Button("Max");
        ans = new TextField("Answer");

        HorizontalLayout h1 = new HorizontalLayout();
        add(num1,num2);
        h1.add(btnPlus, btnMinus, btnMulti, btnDivide, btnMod, btnMax);
        add(h1, ans);

        btnPlus.addClickListener(event -> {
           double n1 = Double.parseDouble((num1.getValue()));
           double n2 = Double.parseDouble((num2.getValue()));

           String out = WebClient.create()
                   .get()
                   .uri("http://localhost:8080/plus/"+n1+"/"+n2)
                   .retrieve()
                   .bodyToMono(String.class)
                   .block();

                    ans.setValue(out);

        });

        btnMinus.addClickListener(event -> {
            double n1 = Double.parseDouble((num1.getValue()));
            double n2 = Double.parseDouble((num2.getValue()));

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);

        });

        btnMulti.addClickListener(event -> {
            double n1 = Double.parseDouble((num1.getValue()));
            double n2 = Double.parseDouble((num2.getValue()));

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multiply/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);

        });

        btnDivide.addClickListener(event -> {
            double n1 = Double.parseDouble((num1.getValue()));
            double n2 = Double.parseDouble((num2.getValue()));

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);

        });

        btnMod.addClickListener(event -> {
            double n1 = Double.parseDouble((num1.getValue()));
            double n2 = Double.parseDouble((num2.getValue()));

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);

        });

        btnMax.addClickListener(event -> {
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("num1", num1.getValue());
            formData.add("num2", num2.getValue());

            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);

        });
    }

}
