<template>
  <div class="bad">
    <div class="calculator">
      <div class="number-pad">
        <div class="ongoing-label">{{ ongoing + " " + operator }}</div>
        <div class="input-label">{{ input }}</div>
        <div class="utilities">
          <div
            class="utility button"
            @click="handleUtility(utility)"
            v-for="utility in utilities"
            :key="utility"
          >
            {{ utility }}
          </div>
        </div>
        <div class="numbers">
          <div
            class="number button"
            @click="handleInput(10 - index)"
            v-for="index in 10"
            :key="index"
          >
            {{ 10 - index }}
          </div>
          <div class="number button" @click="handleInput('.')">.</div>
        </div>
        <div class="operators">
          <div
            class="operator button"
            @click="handleOperator(operator)"
            v-for="operator in operators"
            :key="operator"
          >
            {{ operator }}
          </div>
        </div>
      </div>
    </div>
    <div class="logs">
      <div v-for="(expression, i) in history" :key="i">{{ expression }}</div>
    </div>
  </div>
</template>

<script>
import { calculate } from "../../service/apiUtil";

export default {
  name: "Calculator",
  data() {
    return {
      input: "0",
      ongoing: "",
      operator: "",
      utilities: ["C", "+/-", "%"],
      operators: ["/", "x", "-", "+", "="],
      isAnswer: false,
      history: [],
    };
  },
  methods: {
    async handleCalculation() {
      try {
        const calculation = {
          a: this.ongoing,
          b: this.input,
          operand: this.operator,
        };
        console.log(calculation);

        const response = await calculate(calculation);
        console.log(response.data);
        return response.data;
      } catch (err) {
        console.log(err);
        return null;
      }
    },
    handleInput(number) {
      if (number === ".") {
        if (!this.input.includes(".")) {
          this.input += ".";
        }
      }
      // Unngår ledene 0-er og
      else if (this.input.length >= 8) {
        return;
      } else if (this.isAnswer) {
        this.ongoing = this.input;
        this.operator = "";
        this.input = number.toString();
        this.isAnswer = false;
      } else if (this.input === "0") {
        this.input = number.toString();
      } else {
        this.input += number;
      }
    },
    async handleOperator(operator) {
      if (this.operator !== "") {
        var answer = "";
        const data = await this.handleCalculation();
        answer = data;
        // switch (this.operator) {
        //   case "+":
        //     answer = Number(this.input) + Number(this.ongoing);
        //     break;
        //   case "-":
        //     answer = Number(this.input) - Number(this.ongoing);
        //     break;
        //   case "x":
        //     answer = Number(this.input) * Number(this.ongoing);
        //     break;
        //   case "/":
        //     if (this.input == 0) {
        //       answer = "error";
        //     } else {
        //       answer = Number(this.input) / Number(this.ongoing);
        //     }
        //     break;
        // }
        let formattedAnswer = answer;
        // Behandler tallet
        if (answer.toString().length > 8) {
          formattedAnswer = answer.toString().slice(0, 8);
        }

        //Logger regnestykket
        this.history.push(
          this.ongoing + " " + this.operator + " " + this.input + " = " + answer
        );

        if (operator === "=") {
          this.ongoing =
            this.ongoing + " " + this.operator + " " + this.input + " =";
          this.operator = "";
          this.input = formattedAnswer;
          this.isAnswer = true;
        } else {
          this.ongoing = formattedAnswer;
          this.operator = operator;
          this.input = "0";
        }
      } else {
        this.ongoing = this.input;
        this.operator = operator;
        this.input = "0";
        this.isAnswer = false;
      }
    },
    handleUtility(utility) {
      console.log(utility);
      if (utility === "C") {
        if (this.input === "0") {
          this.ongoing = "";
          this.operator = "";
        }
        this.input = "0";
      } else if (utility === "+/-") {
        this.input *= -1;
      } else if (utility === "%") {
        this.input /= 100;
        this.input = this.input.toString();
      }
    },
  },
};
</script>

<style scoped>
.calculator {
  width: 400px;
  background-color: black;
  color: white;
  margin: 3rem auto;
  border-radius: 15px;
  display: flex;
  flex-direction: column;
}

.ongoing-label {
  display: flex;
  justify-content: right;
  text-align: center;
  grid-column: span 4;
  height: 2rem;
  font-size: 1.5rem;
  opacity: 0.7;
}

.input-label {
  display: flex;
  justify-content: right;
  text-align: right;
  grid-column: span 4;
  height: 4rem;
  font-size: 3rem;
}

.button {
  display: flex;
  justify-content: center;
  align-items: center;

  height: 4rem;
  border-radius: 2em;
  font-weight: bold;
  font-size: 1.5rem;
}

.button:hover {
  opacity: 0.9;
}
.button:active {
  scale: 105;
}

.number-pad {
  display: grid;
  grid-template-columns: repeat(4, 4rem);
  gap: 0.5rem;
  padding: 3rem;
  margin: auto;
}

.utilities {
  grid-column: span 3;
  grid-row: 3;
  display: grid;
  grid-template-columns: repeat(3, 4rem);
  gap: 0.5rem;
}

.utility {
  background-color: lightgrey;
  color: black;
}

.numbers {
  grid-column: 1 / 3;
  grid-row: 4/7;
  display: grid;
  grid-template-columns: repeat(3, 4rem);
  gap: 0.5rem;
}

.number {
  background-color: rgb(58, 58, 58);
}

.number:nth-child(10) {
  grid-column: span 2;
}

.operators {
  grid-row: 3/7;
  grid-column: 4 / 4;
  display: grid;
  gap: 0.5rem;
}

.operator {
  background-color: orange;
}

.logs {
  border: solid 1px;
}
</style>
