import React, { Component } from "react";

class Register extends Component {

    constructor(props) {

        super(props);

        this.state = {

            name: "",
            email: "",
            password: "",

            errors: {

                name: "",
                email: "",
                password: ""

            }

        };

    }

    handleChange = (event) => {

        const { name, value } = event.target;

        let errors = this.state.errors;

        switch (name) {

            case "name":

                errors.name =
                    value.length < 5
                        ? "Name must be at least 5 characters"
                        : "";

                break;

            case "email":

                errors.email =
                    value.includes("@") && value.includes(".")
                        ? ""
                        : "Email should contain @ and .";

                break;

            case "password":

                errors.password =
                    value.length < 8
                        ? "Password must be at least 8 characters"
                        : "";

                break;

            default:
                break;

        }

        this.setState({

            [name]: value,
            errors

        });

    };

    handleSubmit = (event) => {

        event.preventDefault();

        const { errors } = this.state;

        if (
            errors.name === "" &&
            errors.email === "" &&
            errors.password === "" &&
            this.state.name &&
            this.state.email &&
            this.state.password
        ) {

            alert("Registration Successful!");

        } else {

            alert("Please enter valid details.");

        }

    };

    render() {

        return (

            <div className="container">

                <h1>Mail Registration</h1>

                <form onSubmit={this.handleSubmit}>

                    <label>Name</label>

                    <input
                        type="text"
                        name="name"
                        value={this.state.name}
                        onChange={this.handleChange}
                    />

                    <span>{this.state.errors.name}</span>

                    <br /><br />

                    <label>Email</label>

                    <input
                        type="text"
                        name="email"
                        value={this.state.email}
                        onChange={this.handleChange}
                    />

                    <span>{this.state.errors.email}</span>

                    <br /><br />

                    <label>Password</label>

                    <input
                        type="password"
                        name="password"
                        value={this.state.password}
                        onChange={this.handleChange}
                    />

                    <span>{this.state.errors.password}</span>

                    <br /><br />

                    <button type="submit">

                        Register

                    </button>

                </form>

            </div>

        );

    }

}

export default Register;