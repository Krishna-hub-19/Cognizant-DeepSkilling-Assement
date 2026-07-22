import React, { Component } from "react";

class ComplaintRegister extends Component {

    constructor(props) {

        super(props);

        this.state = {

            ename: "",
            complaint: "",
            NumberHolder: Math.floor(Math.random() * 100) + 1

        };

    }

    handleChange = (event) => {

        this.setState({

            [event.target.name]: event.target.value

        });

    };

    handleSubmit = (event) => {

        event.preventDefault();

        const msg =
            "Thanks " + this.state.ename +
            "\nYour Complaint was Submitted." +
            "\nReference ID is : " + this.state.NumberHolder;

        alert(msg);

    };

    render() {

        return (

            <div className="form-container">

                <h1>Register your complaints here!!!</h1>

                <form onSubmit={this.handleSubmit}>

                    <table>

                        <tbody>

                            <tr>

                                <td>Name:</td>

                                <td>

                                    <input
                                        type="text"
                                        name="ename"
                                        value={this.state.ename}
                                        onChange={this.handleChange}
                                        required
                                    />

                                </td>

                            </tr>

                            <tr>

                                <td>Complaint:</td>

                                <td>

                                    <textarea
                                        name="complaint"
                                        rows="4"
                                        cols="22"
                                        value={this.state.complaint}
                                        onChange={this.handleChange}
                                        required
                                    />

                                </td>

                            </tr>

                            <tr>

                                <td></td>

                                <td>

                                    <button type="submit">

                                        Submit

                                    </button>

                                </td>

                            </tr>

                        </tbody>

                    </table>

                </form>

            </div>

        );

    }

}

export default ComplaintRegister;