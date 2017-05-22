import React, { PropTypes, Component } from 'react';
import { requireNativeComponent, View } from 'react-native';

let viewInterface = {
    name: 'NumberPicker',
    propTypes: {
        ...View.propTypes,
        values: PropTypes.arrayOf(String),
        selected: PropTypes.number
    }
};

let NativeNumberPicker = requireNativeComponent('NumberPicker', viewInterface, {
    nativeOnly: {
        onChange: true
    }
});

class NumberPicker extends Component {

    static propTypes = {
        style: PropTypes.any,
        values: PropTypes.arrayOf(String),
        selected: PropTypes.number,
        onChange: PropTypes.func
    };

    static defaultProps = {
        values: ['0', '1', '2', '3'],
        selected: 0
    };

    render() {
        return (
            <NativeNumberPicker style={this.props.style}
                                values={this.props.values}
                                selected={this.props.selected}
                                onChange={this.props.onChange}/>
        );
    }

    onChange = (event) => {
        let value = event.nativeEvent.newValue;
        if (thisprops.onChange) this.props.onChange(value);
    };

}

module.exports.NumberPicker = NumberPicker;