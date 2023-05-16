

function showAllSection() {
    cleanListGroup();
    console.log('start showAllSection')
    const url = '/api/section';
    const listGroup = $('.list-group');

    $.get(url, function (sections) {
        sections.forEach(function (section) {
            console.log(section.id)

            const a = $('<a></a>', {
                class: 'list-group-item list-group-item-action',
                href: '/questions/' + section.id,
            }).appendTo(listGroup);

            const div = $('<div></div>', {
                class: 'd-flex w-100 justify-content-between',
            }).appendTo(a);

            const h5 = $('<h5></h5>', {
                class: 'mb-1',
                text: section.sectionName,
            }).appendTo(div);

            const small = $('<small></small>', {
                text: '3 дня назад',
            }).appendTo(div);
        });
    }).fail(function (error) {
        console.error(error);
    });
}

function allSectionDropdown() {
    const url = '/api/section';
    const dropDown = $('.dropdown-menu');
    const variableField = $('.variable-field');
    let newSection = 'Create New Section...';


    const createNewSection = $('<a></a>', {
        class: 'dropdown-item',
        href: '#',
        text: newSection
    }).appendTo($('<li></li>').appendTo(dropDown));

    createNewSection.on('click', function(event) {
        event.preventDefault();
        // Show input field to enter new section name
        $('.dropdown-toggle').text(newSection)

        //todo нужно создать форму для отправки нового раздела

        const inputField = $('<input>', {
            type: 'text',
            class: 'form-control mb-2 mr-sm-2 variable-element',
            placeholder: 'Enter section name',
        }).insertBefore(variableField);
        inputField.focus();

        // Add event listener to "Create" button
        const createButton = $('<button></button>', {
            type: 'button',
            class: 'btn btn-primary mb-2 variable-element',
            text: 'Create',
        }).insertBefore(variableField);
    });

    $.get(url, function (sections) {
        sections.forEach(function (section) {
            const li = $('<li></li>').appendTo(dropDown);
            const  a = $('<a></a>', {
                class: 'dropdown-item',
                href: '#',
                text: section.sectionName
            }).appendTo(li);
            a.on('click', function(event) {
                event.preventDefault();
                // Set text of button to selected section name
                $('.dropdown-toggle').text(section.sectionName);
            });
        });
    }).fail(function (error) {
        console.error(error);
    });
}

function cleanListGroup() {
    $("a:has(small)").remove()
}
function cleanVariableField() {
    $('.variable-element').remove();
}

