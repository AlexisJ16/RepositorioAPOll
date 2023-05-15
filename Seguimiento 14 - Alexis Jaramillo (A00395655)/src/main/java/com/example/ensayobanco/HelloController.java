package com.example.ensayobanco;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class HelloController implements Initializable {

    public Button addButton;
    public Button deleteButton;
    public TableColumn descriptionColumn;
    public TableColumn typeColumn;
    public TableColumn amountColumn;
    public Button showIncomesButton;
    public Button showExpensesButton;
    public Button showAllButton;
    public Label totalIncomesLabel;
    public Label totalExpensesLabel;
    public Label totalBalanceLabel;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField descriptionField;

    @FXML
    private ChoiceBox<String> typeChoiceBox;

    @FXML
    private TextField amountField;

    @FXML
    private Label balanceLabel;

    @FXML
    private TableView<IncomeExpense> incomeExpenseTableView;

    @FXML
    private TableColumn<IncomeExpense, LocalDate> dateColumn;

    private final ObservableList<IncomeExpense> incomeExpenseList = FXCollections.observableArrayList();


    public static class IncomeExpense {

        private SimpleObjectProperty<LocalDate> date;
        private SimpleStringProperty description;
        private SimpleStringProperty type;
        private SimpleDoubleProperty amount;

        public IncomeExpense(LocalDate date, String description, String type, double amount) {
            this.date = new SimpleObjectProperty<>(date);
            this.description = new SimpleStringProperty(description);
            this.type = new SimpleStringProperty(type);
            this.amount = new SimpleDoubleProperty(amount);
        }

        public LocalDate getDate() {
            return date.get();
        }

        public SimpleObjectProperty<LocalDate> dateProperty() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date.set(date);
        }

        public String getDescription() {
            return description.get();
        }

        public SimpleStringProperty descriptionProperty() {
            return description;
        }

        public void setDescription(String description) {
            this.description.set(description);
        }

        public String getType() {
            return type.get();
        }

        public SimpleStringProperty typeProperty() {
            return type;
        }

        public void setType(String type) {
            this.type.set(type);
        }

        public double getAmount() {
            return amount.get();
        }

        public SimpleDoubleProperty amountProperty() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount.set(amount);
        }

    }

    private void updateBalance() {
        double balance = 0.0;
        for (IncomeExpense ie : incomeExpenseList) {
            if (ie.getType().equals("Ingreso")) {
                balance += ie.getAmount();
            } else {
                balance -= ie.getAmount();
            }
        }
        String formattedBalance = String.format("$%.2f", balance);
        balanceLabel.setText("Balance: " + formattedBalance);
    }

    @FXML
    private void handleAddButton(ActionEvent event) {
        LocalDate date = datePicker.getValue();
        String description = descriptionField.getText();
        String type = typeChoiceBox.getValue();
        double amount = Double.parseDouble(amountField.getText());

        IncomeExpense incomeExpense = new IncomeExpense(date, description, type, amount);
        incomeExpenseList.add(incomeExpense);
    }

    @FXML
    private void handleDeleteButton(ActionEvent event) {
        // Código para eliminar un ingreso/gasto
        updateBalance();
    }

    @FXML
    private void handleShowIncomesButton(ActionEvent event) {
        incomeExpenseTableView.setItems(FXCollections.observableArrayList(incomeExpenseList.stream()
                .filter(ie -> ie.getType().equals("Ingreso"))
                .collect(Collectors.toList())));
    }

    @FXML
    private void handleShowExpensesButton(ActionEvent event) {
        incomeExpenseTableView.setItems(FXCollections.observableArrayList(incomeExpenseList.stream()
                .filter(ie -> ie.getType().equals("Gasto"))
                .collect(Collectors.toList())));
    }

    @FXML
    private void handleShowAllButton(ActionEvent event) {
        incomeExpenseTableView.setItems(FXCollections.observableArrayList(incomeExpenseList));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        incomeExpenseList.add(new IncomeExpense(LocalDate.of(2003, 5, 2), "Salario", "Ingreso", 1000.0));
        incomeExpenseList.add(new IncomeExpense(LocalDate.of(2023, 5, 2), "Comida", "Gasto", -50.0));

        // vincular la lista de ingresos y gastos a la tabla
        incomeExpenseTableView.setItems(incomeExpenseList);

        // Ordenar lista por fecha descendente
        incomeExpenseList.sort(Comparator.comparing(IncomeExpense::getDate).reversed());

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dateColumn.setCellFactory(column -> new TableCell<IncomeExpense, LocalDate>() {
            @Override
            protected void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (empty) {
                    setText("");
                } else {
                    setText(formatter.format(date));
                }
            }
        });



    }
}


