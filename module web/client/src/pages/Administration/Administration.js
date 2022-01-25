import React from 'react';
import './Administration.scss';
 

const Administration = () => {
    return (
        <div>
            <h1 className='admin'>Nombre de Place</h1>
            <table>
            <tr>
                <td>Court</td>
                <td>Court central cat 1</td>
                <td>Court central cat 2</td>
                <td>Court annexe 1</td>
                <td>Court annexe 2</td>
                <td>Court annexe 3</td>
            </tr>
            <tr>
                <td>Nb de place</td>
                <td>200</td>
                <td>200</td>
                <td>200</td>
                <td>200</td>
                <td>200</td>
            </tr>
            </table>


            <h1 className='admin'>Prix</h1>
            <table>
            <tr>
                <td>Jour</td>
                <td>cat 1</td>
                <td>cat 2</td>
                <td>annexe</td>
            </tr>
            <tr>
                <td>Dimanche</td>
                <td>30</td>
                <td>10</td>
                <td>7.5</td>
            </tr>
            <tr>
                <td>Lundi</td>
                <td>30</td>
                <td>10</td>
                <td>7.5</td>
            </tr>
            <tr>
                <td>Mardi</td>
                <td>30</td>
                <td>10</td>
                <td>7.5</td>
            </tr>
            <tr>
                <td>Mercredi</td>
                <td>30</td>
                <td>10</td>
                <td>7.5</td>
            </tr>
            <tr>
                <td>Jeudi</td>
                <td>30</td>
                <td>10</td>
                <td>7.5</td>
            </tr>
            <tr>
                <td>Vendredi</td>
                <td>30</td>
                <td>10</td>
                <td>7.5</td>
            </tr>
            <tr>
                <td>Samedi</td>
                <td>30</td>
                <td>10</td>
                <td>7.5</td>
            </tr>
            <tr>
                <td>Dimanche</td>
                <td>30</td>
                <td>10</td>
                <td>7.5</td>
            </tr>
            </table>

        </div>
    );
};

export default Administration;